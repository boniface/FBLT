package FBLT.controllers.advert;

import FBLT.domain.advert.Advert;
import FBLT.service.advert.ImplAdvertService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.util.ArrayList;

/**
 * Created by nzetwa01 on 11/29/2016.
 */
@RestController
public class AdvertItemController {

    @Autowired
    ImplAdvertService advertService;

    @RequestMapping(value = {"/item{advertId}"}, method = RequestMethod.GET)
    public ModelAndView items(@PathVariable("advertId") String advertId) {

        ModelAndView modelAndView = new ModelAndView("item");

        Advert advert = advertService.readById(advertId);

        ArrayList<String> images = new ArrayList<>();

        String img_path = advert.getImagepaths().get(0);

        if (advert.getImagepaths().size() > 1) {
            for (String path : advert.getImagepaths())
                images.add(path);
        }

        modelAndView.addObject("item", img_path);
        modelAndView.addObject("item_iamges", images);

        return modelAndView;
    }
}
