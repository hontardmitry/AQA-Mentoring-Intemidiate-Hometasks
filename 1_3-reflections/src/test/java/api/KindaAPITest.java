package api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.enums.TestTypes.API;

import common.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.annotations.TestType;

@TestType(API)
public class KindaAPITest extends BaseTest {
    @ParameterizedTest
    @DisplayName("Switch-case test")
    @CsvSource({
        "Open,Open,true",
        "Awaiting reply from customer,Customer replied,false",
//        "Awaiting reply from customer,Awaiting reply from customer,false",
        "Closed,Open,true",
        "Closed,Closed,false",
    })

    public void assertCartItemStatusAfterQuantityUpdate(String initialStatus, String actualStatus,
                                                        boolean isReopenEnabled) {
        String expectedStatus = switch (initialStatus) {
            case "Closed" -> {
                if (isReopenEnabled) {
                    yield "Open";
                } else {
                    yield initialStatus;
                }
            }
            case "New", "Open", "Customer replied" -> initialStatus;
            case "Awaiting reply from customer" -> "Customer replied";
            default -> throw new IllegalArgumentException("Invalid data is provided");
        };

        assertEquals(expectedStatus, actualStatus);
    }
}
