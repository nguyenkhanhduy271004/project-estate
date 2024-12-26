<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="customerListAPI" value="/admin/customer-list"/>
<c:url var="customerAPI" value="/api/customer"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
        <%--<spring:message code="label.user.list"/>--%>
        Danh sách khách hàng
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
                    <li class="active">Danh sách khách hàng</li>
                </ul><!-- /.breadcrumb -->


            </div>

            <div class="page-content">

                <div class="page-header">
                    <h1>
                        Danh sách khách hàng
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
                                    <form:form id="listForm" action="${customerListAPI}"
                                            method="GET" modelAttribute="modalSearch">
                                    <div class="row">
                                        <div class="form-group">
                                            <div class="col-xs-12">
                                                <div class="col-sm-4">
                                                    <label class="name">Tên khách hàng</label>
                                                    <form:input class="form-control"
                                                                path="fullName"></form:input>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label class="name">SĐT</label>
                                                    <form:input class="form-control"
                                                                path="phone"></form:input>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label class="name">Email</label>
                                                    <form:input class="form-control"
                                                                path="email"></form:input>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-xs-12">
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
                    <div class="pull-right" style="margin-right: 11px">
                        <a href="/admin/customer-add">
                            <button class="btn btn-info" title="Thêm khách hàng">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                     fill="currentColor" class="bi bi-person-fill-add"
                                     viewBox="0 0 16 16">
                                    <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0m-2-6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
                                    <path d="M2 13c0 1 1 1 1 1h5.256A4.5 4.5 0 0 1 8 12.5a4.5 4.5 0 0 1 1.544-3.393Q8.844 9.002 8 9c-5 0-6 3-6 4"/>
                                </svg>
                                <path
                                        d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"/>
                                <path
                                        d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                <path
                                        d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                </svg>
                            </button>
                        </a>
                        <button class="btn btn-danger" title="Xóa khách hàng"
                                onclick="deleteCustomers()">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                 fill="currentColor" class="bi bi-person-fill-dash"
                                 viewBox="0 0 16 16">
                                <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1m0-7a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
                                <path d="M2 13c0 1 1 1 1 1h5.256A4.5 4.5 0 0 1 8 12.5a4.5 4.5 0 0 1 1.544-3.393Q8.844 9.002 8 9c-5 0-6 3-6 4"/>
                            </svg>
                            <path
                                    d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"/>
                            <path
                                    d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                            <path
                                    d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                            </svg>
                        </button>
                    </div>
                </div>
                <div class="col-xs-12">
                    <div class="row">
                        <div class="col-xs-12">
                            <h4>Danh sách khách hàng</h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12" bis_skin_checked="1">
                            <table id="simple-table"
                                   class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th class="center">
                                        <label class="pos-rel">
                                            <input type="checkbox" class="ace" id="select-all">
                                            <span class="lbl"></span>
                                        </label>
                                    </th>
                                    <th>Tên khách hàng</th>
                                    <th>Số điện thoại</th>
                                    <th>Email</th>
                                    <th>Nhu cầu</th>
                                    <th>Người thêm</th>
                                    <th>Ngày thêm</th>
                                    <th>Tình trạng</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="customer" items="${customers}">
                                    <tr>
                                        <td class="center">
                                            <label class="pos-rel">
                                                <input type="checkbox" class="ace select-checkbox"
                                                       data-customer-id="${customer.id}">
                                                <span class="lbl"></span>
                                            </label>
                                        </td>
                                        <td>${customer.name}</td>
                                        <td>${customer.customerPhone}</td>
                                        <td>${customer.email}</td>
                                        <td>${customer.demand}</td>
                                        <td>${customer.createdBy}</td>
                                        <td>${customer.createdDate}</td>
                                        <td>${customer.status}</td>
                                        <td>
                                            <div class="hidden-sm hidden-xs btn-group">
                                                <security:authorize
                                                        access="hasRole('MANAGER')">
                                                    <button class="btn btn-xs btn-success"
                                                            title="Giao khách hàng"
                                                            onclick="assignmentCustomer(${customer.id})">
                                                        <i class="ace-icon glyphicon glyphicon-align-justify"></i>
                                                    </button>
                                                </security:authorize>
                                                <a class="btn btn-xs btn-info"
                                                   href="/admin/customer-edit-${customer.id}">
                                                    <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                </a>
                                                <security:authorize
                                                        access="hasRole('MANAGER')">
                                                          <button class="btn btn-xs btn-danger"
                                                        onclick="deleteCustomer(${customer.id})">
                                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                </button>
                                                </security:authorize>

                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <input type="hidden" id="customerId" name="customerId" value="">
                            </table>
                        </div><!-- /.span -->
                    </div>
                    <div class="row pull-right" style="margin-right: 0px">
                        <nav aria-label="Pagination">
                            <ul class="pagination justify-content-center">
                                <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
                                    <a class="page-link"
                                       href="${currentPage > 1 ? '?page=' + (currentPage - 1) : '#'}"
                                       tabindex="${currentPage == 1 ? '-1' : ''}"
                                       aria-disabled="${currentPage == 1}">
                                        Trước
                                    </a>
                                </li>

                                <c:forEach var="i" begin="1" end="${totalPages}">
                                    <li class="page-item ${currentPage == i ? 'active' : ''}">
                                        <a class="page-link" href="?page=${i}">${i}</a>
                                    </li>
                                </c:forEach>

                                <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
                                    <a class="page-link"
                                       href="${currentPage < totalPages ? '?page=' + (currentPage + 1) : '#'}"
                                       aria-disabled="${currentPage == totalPages}">
                                        Sau
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
<div class="modal fade" id="assignmentCustomerModal" role="dialog"
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
<script>
  function assignmentCustomer(customerId) {
    $('#customerId').val(customerId);
    loadStaffs(customerId);
  }

  function loadStaffs(customerId) {
    $.ajax({
      type: 'GET',
      url: '${customerAPI}/' + customerId + '/staffs',
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
        $('#assignmentCustomerModal').modal('show');
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
    data['customerId'] = $('#customerId').val();
    var staffs = $('#staffList').find('tbody input[type=checkbox]:checked').map(function () {
      return $(this).val();
    }).get();
    data['staffs'] = staffs;
    assignCustomerForStaffs(data);
  });

  function assignCustomerForStaffs(data) {
    $.ajax({
      type: 'POST',
      url: '${customerAPI}/assignment',
      data: JSON.stringify(data),
      contentType: 'application/json',
      dataType: 'json',
      success: function (response) {
        window.location.href = "<c:url value="/admin/customer-list"/>";
      },
      error: function (response) {
        window.location.href = "<c:url value="/admin/customer-list"/>";
      }
    });
  }

  function deleteCustomer(customerId) {
    $.ajax({
      type: 'DELETE',
      url: '${customerAPI}/' + customerId,
      contentType: 'application/json',
      dataType: 'json',
      success: function (response) {
        window.location.href = "<c:url value="/admin/customer-list"/>";
      },
      error: function (response) {
        window.location.href = "<c:url value="/admin/customer-list"/>";
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
    getSelectedcustomerIds();
  });

  $('.select-checkbox').click(function () {
    var allChecked = $('.select-checkbox:checked').length === $('.select-checkbox').length;
    $('#select-all').prop('checked', allChecked);
    getSelectedcustomerIds();
  });

  function getSelectedcustomerIds() {
    var selectedIds = [];
    $('.select-checkbox:checked').each(function () {
      selectedIds.push($(this).data('customer-id'));
    });
    return selectedIds;
  };

  function deleteCustomers() {
    var ids = getSelectedcustomerIds();
    if (ids.length === 0) {
      alert("Vui lòng chọn ít nhất một khách hàng để xóa.");
      return;
    }

    var idsString = ids.join(',');

    $.ajax({
      type: 'DELETE',
      url: '${customerAPI}/delete-' + idsString,
      contentType: 'application/json',
      dataType: 'json',
      success: function (response) {
        window.location.href = "<c:url value='/admin/customer-list'/>";
      },
      error: function (response) {
        window.location.href = "<c:url value='/admin/customer-list'/>";
      }
    });
  }


</script>
</body>
</html>
