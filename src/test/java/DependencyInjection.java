import com.javaschool.ev.domain.Train;
import org.junit.BeforeClass;

public class DependencyInjection {
    private static Train train;

    @BeforeClass
    public static void init (){
        /*ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        train = (Train) ctx.getBean("train", Train.class);*/
    }
}
