package testcase;

import com.ggsmida.util.Base64;
import junit.framework.Assert;
import org.junit.Test;

/**
 * 测试Base64工具类
 * Created by junwuguo on 2017/1/13 0013.
 */
public class Base64Test {

    //测试解密普通字符串
    @Test
    public void testDecode() throws Exception {
        String normalString = "MTIzNDU2";
        Assert.assertEquals("equals", "123456", Base64.decode(normalString));
    }

    //测试解密null
    @Test
    public void testDecodeNull() throws Exception {
        String normalString = null;
        Assert.assertEquals("equals", "", Base64.decode(normalString));
    }

    //测试加密普通字符串
    @Test
    public void testEncode() throws Exception {
        String normalString = "123456";
        Assert.assertEquals("equals", "MTIzNDU2", Base64.encode(normalString));
    }

    //测试加密null
    @Test
    public void testEncodeNull() throws Exception {
        String normalString = null;
        Assert.assertEquals("equals", "", Base64.encode(normalString));
    }

}