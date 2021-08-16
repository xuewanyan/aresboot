import com.cn.lombok.MessageRead;
import com.cn.lombok.SaleTicket;
import com.cn.service.IMessageService;
import com.cn.vo.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

public class MessageTest {

    @Autowired
    IMessageService messageService;
    @Test
    public void test(){
//        Message message = Message.builder().title("建").content("造").pubdate(new Date()).build();
//
//        System.out.println(message);
    }
    @Test
    public void testMessageRead(){
        MessageRead messageRead = MessageRead.builder().fileName("myy.txt").filePath("D:"+ File.separator).build();
        System.out.println(messageRead.loag());
    }
    @Test
    public void testSaleTicketRead(){
        SaleTicket saleTicket = new SaleTicket(11);
        for (int i = 0;i<10;i++){
            new Thread(()->{
                saleTicket.sale();
            },"==="+i).start();

        }
    }

    @Test
    public Class<?> messageService() throws ClassNotFoundException {
        // 测试reset
        StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if ("main".equals(stackTraceElement.getMethodName())) {
                System.out.println(stackTraceElement.getMethodName());
                return Class.forName(stackTraceElement.getClassName());
            }

        }
        return  null;
    }
    @Test
    public void equsa(){
        Company messageRead = new Company();
        System.out.println(Company.class.isInstance(messageRead));
    }

}
