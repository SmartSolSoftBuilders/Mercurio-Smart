package qtx.component.front.helper.spring;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import qtx.component.front.helper.ParametrosHelperBean;

import qtx.component.front.helper.ParametrosHelperBinder;
import qtx.component.front.helper.bean.DataHelperBean;
import qtx.component.front.helper.bean.HelperModelProvider;
import test.data.DataTest;

public final class GUIHelperController extends AbstractController {
    
    private ParametrosHelperBinder helperBinder;
    private HelperModelProvider modelProvider;
    
    public GUIHelperController() {
        setSupportedMethods(new String[]{METHOD_GET, METHOD_POST});
    }
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        Map <String, DataHelperBean>map = new HashMap<String, DataHelperBean>();
        //obtener el modelo del helperbinder.
        
        //ModelAndView mav = new ModelAndView("jsp-test","params", helperBinder.bind(request));
        
        ParametrosHelperBean params = helperBinder.bind(request);
        map.put("helper", modelProvider.getModel(params));
        ModelAndView mav = new ModelAndView("helper", map);
        
        return mav;
    }
    
    public void setHelperBinder(ParametrosHelperBinder helperBinder) {
        this.helperBinder = helperBinder;
    }
    
    public void setModelProvider(HelperModelProvider modelProvider) {
        this.modelProvider = modelProvider;
    }
    
}
