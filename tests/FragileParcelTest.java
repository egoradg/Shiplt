
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class FragileParcelTest {
    @Test
    public void CheckCost(){
        FragileParcel parcel=new FragileParcel("q", 1,"w", 1);
        assertEquals(4, parcel.calculateDeliveryCost());
    }
}
