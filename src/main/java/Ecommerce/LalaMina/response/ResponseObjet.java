package Ecommerce.LalaMina.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseObjet<T> {
    private boolean success;
    private String message;
    private T data;

}
