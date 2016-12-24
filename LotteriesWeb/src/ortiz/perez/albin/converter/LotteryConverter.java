/**
 * 
 */
package ortiz.perez.albin.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ortiz.perez.albin.entities.Lottery;

/**
 * @author aposo
 *
 */
@FacesConverter(value="lotconv")
public class LotteryConverter implements Converter{


    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
	// TODO Auto-generated method stub
	return ((Lottery)value).getLottery_name();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
	// TODO Auto-generated method stub
	Lottery lot = new Lottery();
	lot.setLottery_name(value);
	return lot.getLottery_name();
    }

}
