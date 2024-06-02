import java.text.DecimalFormat;

public class Moneda {


    private String base,conversion;
    private double valor,valorMoneda;

    public  Moneda(MonedaR monedaR,Double valor){
        this.valor= valor;
        this.base = monedaR.base_code();
        this.valorMoneda = Double.parseDouble(monedaR.conversion_result());
        this.conversion = monedaR.target_code();
    }
    public Moneda(double valor, String base, String conversion ) {
        this.valor = valor;
        this.base = base;
        this.valorMoneda = valorMoneda;
        this.conversion = conversion;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getConversion() {
        return conversion;
    }

    public void setConversion(String conversion) {
        this.conversion = conversion;
    }

   public double getValor() {
        return valor;
   }


public void setValor(double valor) {
       this.valor = valor;
   }

    @Override
    public String toString() {
        DecimalFormat formato1 = new DecimalFormat("#.00");
        return "{" +
                "EL valor de "+ formato1.format(valor)+"'"+base+"'"+" son "+formato1.format(valorMoneda)+"'"+conversion+"'"+"}";

    }
}
