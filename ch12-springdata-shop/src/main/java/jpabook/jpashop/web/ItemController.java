package jpabook.jpashop.web;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

/**
 * User: HolyEyE
 * Date: 2013. 12. 4. Time: 오후 9:07
 */
@Controller
@SessionAttributes("item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping(value = "/items/new", method = RequestMethod.GET)
    public String createForm() {
        return "items/createItemForm";
    }

    @RequestMapping(value = "/items/new", method = RequestMethod.POST)
    public String create(Book item) {

        itemService.saveItem(item);
        return "redirect:/items";
    }

    /**
     * 상품 수정 폼
     */
    @RequestMapping(value = "/items/{itemId}/edit", method = RequestMethod.GET)
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {

        Item item = itemService.findOne(itemId);
        model.addAttribute("item", item);
        return "items/updateItemForm";
    }

    /**
     * 상품 수정
     */
    @RequestMapping(value = "/items/{itemId}/edit", method = RequestMethod.POST)
    public String updateItem(@ModelAttribute("item") Book item, SessionStatus status) {

        itemService.saveItem(item);
        status.setComplete();
        return "redirect:/items";
    }

    /**
     * 상품 목록
     */
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String list(Model model) {

        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }

}
