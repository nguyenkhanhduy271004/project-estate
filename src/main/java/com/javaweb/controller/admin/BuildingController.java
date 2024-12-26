package com.javaweb.controller.admin;


import com.javaweb.enums.BuildingType;
import com.javaweb.enums.DistrictCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingRequestDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.IUserService;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {

  @Autowired
  private IBuildingService buildingService;

  @Autowired
  private IUserService userService;

  @RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
  public ModelAndView buildingList(@ModelAttribute BuildingSearchRequest buildingSearchRequest,
      @RequestParam Map<String, Object> params,
      @RequestParam(value = "typeCode", required = false) List<String> typeCode,
      @RequestParam(value = "page", defaultValue = "1", required = false) int page,
      @RequestParam(value = "size", defaultValue = "10", required = false) int size,
      HttpServletRequest request) {
    ModelAndView mav = new ModelAndView("admin/building/list");

    if (SecurityUtils.getAuthorities().contains("ROLE_STAFF")) {
      Long staffId = SecurityUtils.getPrincipal().getId();
      buildingSearchRequest.setStaffId(staffId);
    }
    List<BuildingDTO> buildings = buildingService.findAll(params, typeCode, page, size);
    Map<Long, String> staffs = userService.getStaffs();
    Long totalRecords = buildingService.countBuildings(params, typeCode);
    int totalPages = (int) Math.ceil((double) totalRecords / size);

    mav.addObject("modalSearch", buildingSearchRequest);
    mav.addObject("buildings", buildings);
    mav.addObject("staffs", staffs);
    mav.addObject("districts", DistrictCode.type());
    mav.addObject("typeCode", BuildingType.type());
    mav.addObject("currentPage", page);
    mav.addObject("pageSize", size);
    mav.addObject("totalPages", totalPages);

    return mav;
  }

  @RequestMapping(value = "/admin/building-add", method = RequestMethod.GET)
  public ModelAndView buildingAddView(
      @ModelAttribute("buildingEdit") BuildingRequestDTO buildingRequestDTO,
      HttpServletRequest request) {
    ModelAndView mav = new ModelAndView("admin/building/edit");
    mav.addObject("districts", DistrictCode.type());
    mav.addObject("typeCode", BuildingType.type());
    return mav;
  }


  @RequestMapping(value = "/admin/building-edit-{id}", method = RequestMethod.GET)
  public ModelAndView buildingEditView(
      @PathVariable Long id) {
    ModelAndView mav = new ModelAndView("admin/building/edit");
    BuildingRequestDTO buildingRequestDTO = buildingService.find(id);
    mav.addObject("buildingEdit", buildingRequestDTO);
    mav.addObject("districts", DistrictCode.type());
    mav.addObject("typeCode", BuildingType.type());

    return mav;
  }


  @RequestMapping(value = "/admin/building-delete-{id}", method = RequestMethod.DELETE)
  public void deleteBuilding(@PathVariable Long id) {
    buildingService.delete(id);
    System.out.println("ok");
  }


}
