
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PerishableParcelTest {

    private static PerishableParcel parcel=new PerishableParcel("q", 1,"w", 1, 10);

    @Test
    public void CheckCost(){
        assertEquals(3, parcel.calculateDeliveryCost());
    }

    @Test
    public void ShouldReturnTrueWhenExpired(){
        assertTrue(parcel.isExpired(15));
    }

    @Test
    public void ShouldReturnFalseWhenNotExpired(){
        assertFalse(parcel.isExpired(5));
    }
}
