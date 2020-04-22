package com.example.demo;

import com.example.demo.design.pattern.ContextProduct;
import com.example.demo.design.pattern.OperationAddBaseProduct;
import com.example.demo.design.pattern.ProductOnline;
import com.example.demo.putong.ProductCombinedItem;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
import com.spire.doc.Document;
import com.spire.doc.ToPdfParameterList;
import com.spire.pdf.security.*;
*/

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/16 13:54
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class NumberTest extends DemoApplicationTests{

    @Test
    public void bigdecimal(){
        BigDecimal a = new BigDecimal("-3.33");
        BigDecimal b = new BigDecimal("4.44");

        if (a.compareTo(BigDecimal.ZERO) == 0){
            System.out.println("等于");
        }else if(a.compareTo(BigDecimal.ZERO) == 1){
            System.out.println("大于");
        }else if(a.compareTo(BigDecimal.ZERO) == -1) {
            System.out.println("小于");
        }
    }

    @Test
    public void ObjectTest(){
        Integer a = 1;
        Integer b = 1;
        int  aa = 1;
        int  bb = 1;

        if (a.equals(b)){
            log.info("等于");
        }else{
            log.info("不等于");
        }

        if (aa == bb){
            log.info("aa == bb");
        }else{
            log.info("aa != bb");
        }
    }

    @Test
    public void operatiorTest(){
        BigDecimal price = BigDecimal.valueOf(10.23);
        BigDecimal amount = price.multiply(BigDecimal.valueOf(100));
        int productPrice = amount.intValue();
        System.out.println("得到的金额："+productPrice);
    }

    @Test
    public void retainNumberTest(){
        Double number = 7832.5675789;
        DecimalFormat decimalFormat = new DecimalFormat("#.000");
        log.info("四舍五入保留三位小数：{}",decimalFormat.format(number));
    }

    @Test
    public void amountTest(){
        BigDecimal lastAmount = new BigDecimal(18929.69);
        BigDecimal thisAmount = new BigDecimal(18783.98);
        BigDecimal subtract = lastAmount.subtract(thisAmount).setScale(2,BigDecimal.ROUND_UP);
        log.info("差额：{}",subtract);
    }

    @Test
    public void save(){
        /*DecimalFormat df = new DecimalFormat("###.#");
        BigDecimal b1 = new BigDecimal("28.1109");
        BigDecimal b2 = new BigDecimal("28.00");
        System.out.println("小数格式化：" + df.format(b1));
        System.out.println("整数格式化：" + df.format(b2));*/
        Integer discountPrice = 2;
        Integer oldSellingPrice = 2;
        DecimalFormat df = new DecimalFormat("###.#");
        BigDecimal discountRate =  new BigDecimal(discountPrice).multiply(new BigDecimal(10)).divide(new BigDecimal(oldSellingPrice),1,BigDecimal.ROUND_DOWN);
        log.info("得到的折扣是：{}",df.format(discountRate));
    }

    @Test
    public void isNullTest(){
        BigDecimal money = new BigDecimal("");
        if (money == null){
            log.info("kong");
        }else{
            log.info("不是kong");
        }
    }

    @Test
    public void StrategyDemo(){
        ContextProduct contextProduct = new ContextProduct(new OperationAddBaseProduct());
        ProductOnline online = new ProductOnline();
        online.setTransformType((byte)1);
        online.setProductName("基础商品");
        log.info("得到的结果：{}",contextProduct.executeStrategy(online));
    }

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
    public  void mainDemo(){
        Set<Integer> set1= Sets.newHashSet(1,2,3,4,5);
        Set<Integer> set2=Sets.newHashSet(3,4,5,6,7);

        List<String> list1 = Arrays.asList("a","b","c","d","a");
        List<String> list2 = Arrays.asList("c","d","e","f");
        Set<String> setOne = new HashSet<>(list1);
        Set<String> setTwo = new HashSet<>(list2);
      /*  System.out.println("得到的数据："+ setOne);*/


        //交集
        Sets.SetView<String> intersection = Sets.intersection(setOne, setTwo);
        List<String> collect = intersection.parallelStream().collect(Collectors.toList());
        log.info("得到的数据：{}",collect);


        //差集
        System.out.println("差集为：");
        Sets.SetView<String> diff=Sets.difference(setOne, setTwo);
        for (String integer : diff) {
            System.out.println(integer);
        }
        //并集
        System.out.println("并集为：");
        Sets.SetView<Integer> union=Sets.union(set1, set2);
        for (Integer integer : union) {
            System.out.println(integer);
        }
    }

/*    @Test
    public void wordToPdf(){

        //加载Word示例文档
        Document document1 = new Document();
        document1.loadFromFile("C:\\Users\\Test1\\Desktop\\Sample.docx");

        //保存结果文档
        document1.saveToFile("output/toPDF", FileFormat.PDF);

       // ---------------------------------------------------------------------------

        //加载Word示例文档
        Document document = new Document();
        document.loadFromFile("C:\\Users\\Test1\\Desktop\\Sample.docx");

        //创建一个参数
        ToPdfParameterList toPdf = new ToPdfParameterList();

        //设置密码
        String password = "abc123";
        toPdf.getPdfSecurity().encrypt(password, password, PdfPermissionsFlags.None, PdfEncryptionKeySize.Key_128_Bit);

        //保存文档.
        document.saveToFile("output/toPDFWithPassword", toPdf);

    }*/
}
