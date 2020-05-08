package com.example.demo;


import com.example.demo.putong.ProductCombinedItem;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;



/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/16 13:54
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class NumberTest extends DemoApplicationTests{

    @Test
    public void testsss(){
        List<ProductCombinedItem> itemList = Arrays.asList(
                new ProductCombinedItem("123",20),
                new ProductCombinedItem("456",30),
                new ProductCombinedItem("789",40),
                new ProductCombinedItem("709",50));
        System.out.println("得到的结果："+isRepeate(itemList));
    }

    public Boolean isRepeate(List<ProductCombinedItem> itemList){
        Map<String, Long> collect = itemList.parallelStream().map(ProductCombinedItem::getSapProductCode).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<String> result = new ArrayList<>();
        collect.forEach((k,v)->{
            if (v > 1){
                result.add(k);
            }
        });
        if (CollectionUtils.isEmpty(result)){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }




    @Test
    public void wordToPdf() throws IOException, ParserConfigurationException, TransformerException {
      String filepath = "E:\\文件整理";
      String docFile = filepath + "dd.doc";
      final String picturesPath = filepath+ "/image/";
      File picturesDir = new File(picturesPath);
      String content = null;

        HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(docFile));
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
        wordToHtmlConverter.setPicturesManager(new PicturesManager() {
            @Override
            public String savePicture(byte[] content, PictureType pictureType, String suggestedName, float widthInches, float heightInches) {
                File file = new File(picturesPath + suggestedName);
                FileOutputStream fos = null;
                try{
                    fos = new FileOutputStream(file);
                    fos.write(content);
                    fos.close();
                }catch (Exception e){
                    e.getMessage();
                }
                return picturesPath + suggestedName;
            }
        });

        wordToHtmlConverter.processDocument(wordDocument);
        org.w3c.dom.Document htmlDocument = wordToHtmlConverter.getDocument();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(out);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
        serializer.setOutputProperty(OutputKeys.INDENT,"yes");
        serializer.setOutputProperty(OutputKeys.METHOD,"html");
        serializer.transform(domSource,streamResult);
        out.close();
        content = out.toString();
        log.info("获取的内容：{}",content);
    }

    @Test
    public void wordToPdf2(){
        String filepath = "E:\\文件整理";
        String docFile = filepath + "chuiniu.doc";
    }

    /**
     * 非常规字符的区域都替换掉
     */
    private static final String EMOJI_RANGE_REGEX_EX = "([\\x{10000}-\\x{10ffff}\ud800-\udfff])";

    private static final Pattern PATTERN_EX = Pattern.compile(EMOJI_RANGE_REGEX_EX,
            Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);

    /**
     * 查找和移除emoji表情 @param input
     *
     * @param input 可能包含表情的输入文字
     * @return 被移除表情后剩余的文字
     */

    public static String eraseEmojisEx(String input) {
        if (StringUtils.isBlank(input)) {
            return input;
        }

        Matcher matcher = PATTERN_EX.matcher(input);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, StringUtils.EMPTY);
        }

        matcher.appendTail(sb);
        return sb.toString();

    }
}
