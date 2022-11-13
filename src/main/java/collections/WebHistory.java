package collections;

import lombok.Data;

import java.net.URL;
import java.time.LocalDateTime;

@Data
public class WebHistory {
    LocalDateTime creationDate;
    URL url;
}
