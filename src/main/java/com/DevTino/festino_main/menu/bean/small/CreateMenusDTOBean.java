package com.DevTino.festino_main.menu.bean.small;

import com.DevTino.festino_main.menu.domain.DTO.ResponseMenuGetDTO;
import com.DevTino.festino_main.menu.domain.entity.MenuDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateMenusDTOBean {

    public ResponseMenuGetDTO exec(MenuDAO menuDAO){
        return ResponseMenuGetDTO.builder()
                .menuId(menuDAO.getMenuId())
                .menuName(menuDAO.getMenuName())
                .menuDescription(menuDAO.getMenuDescription())
                .menuImage(menuDAO.getMenuImage())
                .menuPrice(menuDAO.getMenuPrice())
                .isSoldOut(menuDAO.getIsSoldOut())
                .menuType(menuDAO.getMenuType().ordinal())
                .build();
    }

    // 해당 부스 메뉴 전체 반환
    public List<ResponseMenuGetDTO> exec(List<MenuDAO> menuDAOList){
        List<ResponseMenuGetDTO> responseMenuGetDTOList = new ArrayList<>();

        // 해당 부스 메뉴 전체 리스트 가져오기
        for(MenuDAO menuDAO : menuDAOList){

            if (!menuDAO.getIsDeleted()) {
                ResponseMenuGetDTO responseMenuGetDTO = exec(menuDAO);

                responseMenuGetDTOList.add(responseMenuGetDTO);
            }
        }
        return responseMenuGetDTOList;
    }
}
