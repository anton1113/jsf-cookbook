package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;

@ManagedBean(name = "fibonacciBean")
@SessionScoped
public class FibonacciBean implements Serializable {

    private int numFibonacci;
    private long result;

    private static final long serialVersionUID = 8150756503956053844L;

    public int getNumFibonacci() {
        return numFibonacci;
    }

    public void setNumFibonacci(int numFibonacci) {
        this.numFibonacci = numFibonacci;
    }

    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }

    private long getFibonacciNumber(int numFibonacci) {
        if (numFibonacci == 1 || numFibonacci == 2) {
            return 1;
        } else {
            long curr = 1;
            long next = 1;
            long sum = 0;

            for (int i = 2; i < numFibonacci; i++) {
                sum = curr + next;
                curr = next;
                next = sum;
            }

            return sum;
        }
    }

    @SuppressWarnings("Duplicates")
    public void performFibonacciOperation() {
        if (numFibonacci <= 0) {
            result = 0L;
        } else {
            result = getFibonacciNumber(numFibonacci);

            FacesContext fc = FacesContext.getCurrentInstance();

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Fibonacci calculation for the: " + numFibonacci + " is: " + result, "");
            fc.addMessage(null, message);
        }
    }

    @SuppressWarnings("Duplicates")
    public void ajaxPerformFibonacciOperation(final AjaxBehaviorEvent event) {
        if (numFibonacci <= 0) {
            result = 0L;
        } else {
            result = getFibonacciNumber(numFibonacci);

            FacesContext fc = FacesContext.getCurrentInstance();

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Calculation", "Fibonacci calculation for the: " + numFibonacci + " is: " + result);
            fc.addMessage(null, message);
        }
    }
}
