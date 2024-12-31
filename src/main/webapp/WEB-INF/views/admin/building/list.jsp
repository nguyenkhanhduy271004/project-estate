<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="buildingListURL" value="/admin/building-list"/>
<c:url var="buildingAPI" value="/api/building"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
        <%--<spring:message code="label.user.list"/>--%>
        Danh sách tòa nhà
    </title>
</head>
<body>
<div class="main-content" id="main-container">
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                  try {
                    ace.settings.check('breadcrumbs', 'fixed')
                  } catch (e) {
                  }
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Home</a>
                    </li>
                    <li class="active">Danh sách tòa nhà</li>
                </ul><!-- /.breadcrumb -->


            </div>

            <div class="page-content">

                <div class="page-header">
                    <h1>
                        Danh sách tòa nhà
                    </h1>

                </div><!-- /.page-header -->
                <div class="row">
                    <div class="col-xs-12" bis_skin_checked="1">
                        <div class="widget-box ui-sortable-handle" bis_skin_checked="1">
                            <div class="widget-header" bis_skin_checked="1">
                                <h5 class="widget-title">Tìm Kiếm</h5>

                                <div class="widget-toolbar" bis_skin_checked="1">


                                    <a href="#" data-action="collapse">
                                        <i class="ace-icon fa fa-chevron-up"></i>
                                    </a>


                                </div>
                            </div>
                            <div class="widget-body"
                                 style="font-family: 'Times New Roman', Times, serif;">
                                <div class="widget-main">
                                    <form:form id="listForm" action="${buildingListURL}"
                                            method="GET" modelAttribute="modalSearch">
                                    <div class="row">
                                            <%--                                        <div class="form-group">--%>
                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-sm-6">
                                                    <label class="name">Tên tòa nhà</label>
                                                    <form:input class="form-control"
                                                                path="name"></form:input>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label class="name">Diện tích sàn</label>
                                                    <form:input class="form-control"
                                                                path="floorArea"></form:input>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-sm-2">
                                                    <label class="name">Quận hiện có</label>
                                                    <form:select class="form-control"
                                                                 path="district" id="district">
                                                        <form:option value="">---Chọn Quận---
                                                        </form:option>
                                                        <form:options items="${districts}"/>

                                                    </form:select>
                                                </div>
                                                <div class="col-sm-5">
                                                    <label class="name">Phường</label>
                                                    <form:input class="form-control"
                                                                path="ward"></form:input>
                                                </div>
                                                <div class="col-sm-5">
                                                    <label class="name">Đường</label>
                                                    <form:input class="form-control"
                                                                path="street"></form:input>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-sm-4">
                                                    <label class="name">Số tầng hầm</label>
                                                    <form:input class="form-control"
                                                                path="numberOfBasement"></form:input>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label class="name">Hướng</label>
                                                    <form:input class="form-control"
                                                                path="direction"></form:input>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label class="name">Hạng</label>
                                                    <form:input class="form-control"
                                                                path="level"></form:input>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-sm-3">
                                                    <label class="name">Diện tích từ</label>
                                                    <form:input class="form-control"
                                                                path="areaFrom"></form:input>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label class="name">Diện tích đến</label>
                                                    <form:input class="form-control"
                                                                path="areaTo"></form:input>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label class="name">Giá thuê từ</label>
                                                    <form:input class="form-control"
                                                                path="rentPriceFrom"></form:input>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label class="name">Giá thuê đến</label>
                                                    <form:input class="form-control"
                                                                path="rentPriceTo"></form:input>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-sm-5">
                                                    <label class="name">Tên quản lý</label>
                                                    <form:input class="form-control"
                                                                path="managerName"></form:input>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label class="name">Điện thoại quản
                                                        lý</label>
                                                    <form:input class="form-control"
                                                                path="managerPhone"></form:input>
                                                </div>
                                                <security:authorize access="hasRole('MANAGER')">
                                                    <div class="col-sm-3">
                                                        <label class="name">Chọn nhân viên phụ
                                                            trách</label>
                                                        <form:select class="form-control"
                                                                     path="staffId"
                                                                     id="staffId">
                                                            <form:option
                                                                    value="">---Chọn nhân viên---
                                                            </form:option>
                                                            <form:options items="${staffs}"/>
                                                        </form:select>
                                                    </div>
                                                </security:authorize>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-sm-6">
                                                    <form:checkboxes items="${typeCode}"
                                                                     path="typeCode"/>

                                                </div>
                                                <div class="col-sm-6"></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-sm-6">
                                                    <button type="button"
                                                            class="btn btn-xs btn-success"
                                                            id="btnSearchBuilding">
                                                        <svg xmlns="http://www.w3.org/2000/svg"
                                                             width="16"
                                                             height="16" fill="currentColor"
                                                             class="bi bi-search"
                                                             viewBox="0 0 16 16">
                                                            <path
                                                                    d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0">
                                                            </path>
                                                        </svg>
                                                        Tìm kiếm
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                </form:form>

                            </div>
                        </div>


                    </div>
                    <security:authorize access="hasRole('MANAGER')">
                        <div class="pull-right" style="margin-right: 11px">
                            <a href="/admin/building-add">
                                <button class="btn btn-info" title="Thêm tòa nhà">
                                    <svg
                                            xmlns="http://www.w3.org/2000/svg" width="16"
                                            height="16" fill="currentColor"
                                            class="bi bi-building-add" viewBox="0 0 16 16">
                                        <path
                                                d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"/>
                                        <path
                                                d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                        <path
                                                d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                    </svg>
                                </button>
                            </a>
                            <button class="btn btn-danger" title="Xóa tòa nhà"
                                    onclick="deleteBuildings()">
                                <svg
                                        xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                        fill="currentColor"
                                        class="bi bi-building-dash" viewBox="0 0 16 16">
                                    <path
                                            d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"/>
                                    <path
                                            d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                    <path
                                            d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                </svg>
                            </button>
                        </div>
                    </security:authorize>
                </div>
            </div>
            <div class="col-xs-12" style="margin-left: 8px">
                <div class="row">
                    <div class="col-xs-12">
                        <h4>Danh sách tòa nhà</h4>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12" bis_skin_checked="1">
                        <table id="simple-table"
                               class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <security:authorize access="hasRole('MANAGER')">
                                    <th class="center">
                                        <label class="pos-rel">
                                            <input type="checkbox" class="ace" id="select-all">
                                            <span class="lbl"></span>
                                        </label>
                                    </th>
                                </security:authorize>
                                <th>Tên tòa nhà</th>
                                <th>Địa chỉ</th>
                                <th>Sô tầng hầm</th>
                                <th>Tên quản lý</th>
                                <th>Số điện thoại</th>
                                <th>DT sàn</th>
                                <th>DT trống</th>
                                <th>DT thuê</th>
                                <th>Phí môi giới</th>
                                <th>Thao tác</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${buildings}">
                                <tr>
                                    <security:authorize
                                            access="hasRole('MANAGER')">
                                        <td class="center">
                                            <label class="pos-rel">
                                                <input type="checkbox" class="ace select-checkbox"
                                                       data-building-id="${item.id}">
                                                <span class="lbl"></span>
                                            </label>
                                        </td>
                                    </security:authorize>
                                    <td>${item.name}</td>
                                    <td>${item.address}</td>
                                    <td>${item.numberOfBasement}</td>
                                    <td>${item.managerName}</td>
                                    <td>${item.managerPhone}</td>
                                    <td>${item.floorArea}</td>
                                    <td>0</td>
                                    <td>${item.rentArea}</td>
                                    <td>${item.brokerageFee}</td>
                                    <td>
                                        <div class="hidden-sm hidden-xs btn-group">
                                            <security:authorize
                                                    access="hasRole('MANAGER')">
                                                <button class="btn btn-xs btn-success"
                                                        title="Giao tòa nhà"
                                                        onclick="assignmentBuilding(${item.id})">
                                                    <i class="ace-icon glyphicon glyphicon-align-justify"></i>
                                                </button>
                                            </security:authorize>

                                            <a class="btn btn-xs btn-info"
                                               href="/admin/building-edit-${item.id}">
                                                <i class="ace-icon fa fa-pencil bigger-120"></i>
                                            </a>
                                            <security:authorize
                                                    access="hasRole('MANAGER')">
                                                <button class="btn btn-xs btn-danger"
                                                        onclick="deleteBuilding(${item.id})">
                                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                </button>
                                            </security:authorize>

                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div><!-- /.span -->
                </div>
                <div class="row" style="margin-right: 0px">
                    <div class="col pull-left" style="margin-left: 14px">
                        ${buildings.size()} items found, displaying 1 to 2.
                    </div>
                    <div class="col pull-right" style="margin: 0px">
                        <nav aria-label="Pagination">
                            <ul class="pagination justify-content-center">
                                <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
                                    <a class="page-link"
                                       href="?page=${currentPage - 1}"
                                       tabindex="${currentPage == 1 ? '-1' : ''}"
                                       aria-disabled="${currentPage == 1}">
                                        <<
                                    </a>
                                </li>

                                <c:forEach var="i" begin="1" end="${totalPages}">
                                    <li class="page-item ${currentPage == i ? 'active' : ''}">
                                        <a class="page-link" href="?page=${i}">${i}</a>
                                    </li>
                                </c:forEach>

                                <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
                                    <a class="page-link"
                                       href="?page=${currentPage + 1}"
                                       aria-disabled="${currentPage == totalPages}">
                                        >>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>

        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->
<div class="modal fade" id="assignmentBuildingModal" role="dialog"
     style="font-family: 'Times New Roman', Times, serif;">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Danh sách nhân viên</h4>
            </div>
            <div class="modal-body">
                <table class="table table-striped table-bordered table-hover" id="staffList">
                    <thead>
                    <tr>
                        <th class="center">Chọn</th>
                        <th class="center">Tên nhân viên</th>
                    </tr>
                    </thead>
                    <tbody id="bodyTable">

                    </tbody>
                </table>
                <input type="hidden" id="buildingId" name="buildingId" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="btnAssigntmentBuilding">Giao tòa
                    nhà
                </button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">Đóng</button>
            </div>
        </div>

    </div>
</div>
<script src="assets/js/jquery.2.1.1.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css"
      rel="stylesheet">
<script>
  function assignmentBuilding(buildingId) {
    $('#buildingId').val(buildingId);
    loadStaffs(buildingId);
  }

  function loadStaffs(buildingId) {
    $.ajax({
      type: 'GET',
      url: '${buildingAPI}/' + buildingId + '/staffs',
      contentType: 'application/json',
      dataType: 'json',
      success: function (response) {
        var row = '';
        $.each(response.data, function (index, item) {
          row += '<tr>';
          row += '<td class="center"><input type="checkbox" value="' + item.staffId + '" '
              + (item.checked
                  ? 'checked' : '') + ' /></td>';
          row += '<td class="center">' + item.fullName + '</td>';
          row += '</tr>';

        })
        ;
        $('#bodyTable').html(row);
        $('#assignmentBuildingModal').modal('show');
      },
      error:
          function (response) {
            console.log("failed");
          }
    });
  }

  $('#btnAssigntmentBuilding').click(function (e) {
    e.preventDefault();
    var data = {};
    data['buildingId'] = $('#buildingId').val();
    var staffs = $('#staffList').find('tbody input[type=checkbox]:checked').map(function () {
      return $(this).val();
    }).get();
    data['staffs'] = staffs;
    assignBuildingForStaffs(data);
  });

  function assignBuildingForStaffs(data) {
    $.ajax({
      type: 'POST',
      url: '${buildingAPI}/assignment',
      data: JSON.stringify(data),
      contentType: 'application/json',
      success: function (response) {
        toastr.success('Giao building thành công', 'Thành công');
        $('#assignmentBuildingModal').modal('hide');
      },
      error: function (response) {
        toastr.error('Có lỗi xảy ra khi giao building', 'Thất bại');
        $('#assignmentBuildingModal').modal('show');
      }
    });
  }

  function deleteBuilding(buildingId) {
    $.ajax({
      type: 'DELETE',
      url: '${buildingAPI}/' + buildingId,
      contentType: 'application/json',
      success: function (response) {
        toastr.success('Xóa building thành công', 'Thành công');
         setTimeout(() => {
          window.location.href = "/admin/building-list";
        }, 2000);
      },
      error: function (response) {
        toastr.error('Có lỗi xảy ra khi xóa building', 'Thất bại');
        window.location.href = "<c:url value="/admin/building-list"/>";
      }
    });
  }

  $('#btnSearchBuilding').click(function (e) {
    e.preventDefault();
    $('#listForm').submit()
  });

  $('#select-all').click(function () {
    var isChecked = $(this).prop('checked');
    $('.select-checkbox').prop('checked', isChecked);
    getSelectedBuildingIds();
  });

  $('.select-checkbox').click(function () {
    var allChecked = $('.select-checkbox:checked').length === $('.select-checkbox').length;
    $('#select-all').prop('checked', allChecked);
    getSelectedBuildingIds();
  });

  function getSelectedBuildingIds() {
    var selectedIds = [];
    $('.select-checkbox:checked').each(function () {
      selectedIds.push($(this).data('building-id'));
    });
    return selectedIds;
  };

  function deleteBuildings() {
    var ids = getSelectedBuildingIds();
    if (ids.length === 0) {
      alert("Vui lòng chọn ít nhất một tòa nhà để xóa.");
      return;
    }

    var idsString = ids.join(',');

    $.ajax({
      type: 'DELETE',
      url: '${buildingAPI}/delete-' + idsString,
      contentType: 'application/json',
      dataType: 'json',
      success: function (response) {
        window.location.href = "<c:url value='/admin/building-list'/>";
      },
      error: function (response) {
        window.location.href = "<c:url value='/admin/building-list'/>";
      }
    });
  }


</script>
</body>
</html>
