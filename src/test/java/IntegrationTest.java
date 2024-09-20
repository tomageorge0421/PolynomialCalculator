import org.example.business_logic.Integration;
import org.example.data_model.Polynomial;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {
    @Test
    public void integrationTest(){
        Polynomial p1 = new Polynomial();
        p1.addValue(3,2);
        p1.addValue(2,3);
        p1.addValue(1,-1);
        p1.addValue(0,5);
        Polynomial rezultat = new Polynomial();
        rezultat.addValue(4,0.5);
        rezultat.addValue(3,1);
        rezultat.addValue(2,-0.5);
        rezultat.addValue(1,5);
        Integration integr = new Integration();
        try{
            Polynomial resultIntegr = integr.IntegratePolynomial(p1);
            Polynomial resultIntegrAux = new Polynomial();
            for (Map.Entry<Integer, Double> entry1 : resultIntegr.getMap().descendingMap().entrySet()){
                if(entry1.getValue()!=0){
                    resultIntegrAux.getMap().put(entry1.getKey(),entry1.getValue());
                }
            }
            assertEquals(rezultat.getMap(), resultIntegrAux.getMap());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
