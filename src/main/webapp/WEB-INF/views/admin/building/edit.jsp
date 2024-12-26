<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="buildingAPI" value="/api/building"/>
<html>
<head>
    <title>Thêm tòa nhà</title>

</head>
<body>
<div class="main-content" id="main-container">
    <div class="main-content"
         style="font-family: 'Times New Roman', Times, serif; font-size: 1.4rem;">
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
                    <li class="active">Dashboard</li>
                </ul><!-- /.breadcrumb -->


            </div>

            <div class="page-content">

                <div class="page-header">
                    <h1>
                        Dashboard
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            overview &amp; stats
                        </small>
                    </h1>

                </div><!-- /.page-header -->
                <div class="row">
                    <form:form modelAttribute="buildingEdit" id="listForm" method="GET">
                        <div class="col-xs-12">
                            <form class="form-horizontal" role="form" id="form-edit">
                                <div class="form-group">
                                    <div class="col-xs-3">Tên tòa nhà</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="name"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Quận</div>
                                    <div class="col-xs-9">
                                        <form:select class="form-control"
                                                     path="district">
                                            <form:option value="">---Chọn Quận---
                                            </form:option>
                                            <form:options items="${districts}"/>

                                        </form:select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Phường</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="ward"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Đường</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="street"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Kết cấu</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="structure"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Số tầng hầm</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="numberOfBasement"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Diện tích sàn</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="floorArea"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Hướng</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="direction"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Hạng</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="level"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Diện tích thuê</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="rentArea"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Mô tả giá</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control"
                                                    path="rentPriceDescription"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Phí dịch vụ</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="serviceFee"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Phí ô tô</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="carFee"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Phí mô tô</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="motoFee"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Phí ngoài giờ</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="overtimeFee"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Tiền điện</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="electricityFee"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Đặt cọc</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="deposit"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Thanh toán</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="payment"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Thời hạn thuê</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="rentTime"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Thời gian trang trí</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="decorationTime"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Tên quản lý</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="managerName"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">SĐT quản lý</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="managerPhone"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Phí môi giới</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="brokerageFee"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Loại tòa nhà</div>
                                    <div class="col-xs-9">
                                        <form:checkboxes items="${typeCode}"
                                                         path="typeCode"/>
                                    </div>
                                </div>
<%--                                <div class="form-group">--%>
<%--                                    <div class="col-xs-3">Ảnh đại diện</div>--%>
<%--                                    <div class="col-xs-9">--%>
<%--                                        <form:input type="file" path="avatar"/>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
                                <div class="form-group">
                                    <div class="col-xs-3"></div>
                                    <div class="col-xs-6">
                                        <c:if test="${not empty buildingEdit.id}">
                                            <button class="btn btn-info"
                                                    id="btnAddOrUpdateBuilding">
                                                Cập nhật tòa
                                                nhà
                                            </button>
                                        </c:if>
                                        <c:if test="${empty buildingEdit.id}">
                                            <button class="btn btn-info"
                                                    id="btnAddOrUpdateBuilding">
                                                Thêm tòa
                                                nhà
                                            </button>
                                        </c:if>
                                        <button class="btn btn-info" id="cancleBtn">Hủy thao tác
                                        </button>
                                    </div>
                                </div>
                                <form:hidden path="id" id="buildingId"/>
                            </form>
                        </div>
                    </form:form>
                </div>
            </div>

        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->
<script src="assets/js/jquery.2.1.1.min.js"></script>

<script>
  $('#btnAddOrUpdateBuilding').click(function (e) {
    e.preventDefault();
    var data = {};
    var typeCode = [];
    var formData = $('#listForm').serializeArray();

    $.each(formData, function (i, v) {
      if (v.name !== 'typeCode') {
        data[v.name] = v.value;
      } else {
        typeCode.push(v.value);
      }
    });

    data['typeCode'] = typeCode;
    if (typeCode != '') {
      addOrUpdateBuilding(data);
    } else {
      window.location.href = "<c:url value="/admin/building-add?type=required"/>";
    }
  });

  function addOrUpdateBuilding(data) {
    $.ajax({
      type: "POST",
      url: "${buildingAPI}",
      data: JSON.stringify(data),
      contentType: "application/json",
      dataType: "json",
      success: function (response) {
        window.location.href = "<c:url value="/admin/building-list"/>";
      },
      error: function (response) {
        window.location.href = "<c:url value="/admin/building-add?error=error"/>";
      }
    })
  }

  $('#cancleBtn').click(function (e) {
    e.preventDefault();
    window.location.href = "<c:url value="/admin/building-list"/>";
  });
</script>
</body>
</html>
