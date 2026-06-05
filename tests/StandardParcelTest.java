import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StandardParcelTest {
    @Test
    public void CheckCost(){
        StandardParcel parcel=new StandardParcel("q", 1,"w", 1);
        assertEquals(2, parcel.calculateDeliveryCost());
    }
}
