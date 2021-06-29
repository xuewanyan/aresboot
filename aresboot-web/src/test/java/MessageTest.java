import com.cn.vo.Message;
import org.junit.jupiter.api.Test;

public class MessageTest {

    @Test
    public void test(){
        Message message = new Message();
        message.title("代码连1").content("代码连2");
        System.out.println(message);
    }
}
