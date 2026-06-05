import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParcelBoxTest {

    private ParcelBox<StandardParcel> box;

    @BeforeEach
    public void beforeEach(){
    box = new ParcelBox<>(10);
    }

    @Test
    public void boxShouldEmptyWhenWeightMoreThenMaxWeight(){
        box.addParcel(new StandardParcel("q", 11,"w", 3));
        assertEquals(0, box.getAllWeight());
    }

    @Test
    public void ShouldReturnNullWhenWeightMoreThenMaxWeight(){
        box.addParcel(new StandardParcel("q", 3,"w", 3));
        box.addParcel(new StandardParcel("q", 8,"w", 3));
        assertEquals(3, box.getAllWeight());
    }
}
