import com.cn.lombok.MessageRead;
import com.cn.lombok.SaleTicket;
import com.cn.service.IMessageService;
import com.cn.service.impl.MessageServiceImpl;
import com.cn.vo.Company;
import com.cn.vo.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.Date;

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
    public void messageService(){
        this.messageService.echo("AOP");
    }

    @Test
    public void equsa(){
        Company messageRead = new Company();
        System.out.println(Company.class.isInstance(messageRead));
    }

}
