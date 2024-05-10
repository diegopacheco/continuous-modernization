import com.github.antipatterns.continuous.modernization.wrapper.impl.AMQImpl;

public class Main{
  public static void main(String args[]){
    AMQImpl client = new AMQImpl();
    client.init().send("test","dev_channel");
  }
}
