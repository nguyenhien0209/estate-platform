<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:url var="deleteUrl" value="/api-admin-building"/>
<c:url var="userAPI" value="/api-user"/>
<c:url var="assignAPI" value="/api-assignment-building"/>
<html>
<head>
    <title>Danh sách tòa nhà</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
            </ul><!-- /.breadcrumb -->
        </div>
        <form method="GET" action="<c:url value='/admin-building' />" id="formSubmit">
            <div class="page-content">
                <c:if test="${not empty message}">
                    <div class="alert alert-${alert}">
                            ${message}
                    </div>
                </c:if>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="widget-box table-filter">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <div class="form-horizontal">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right">Tên tòa nhà</label>
                                            <div class="col-sm-9">
                                                <input type="text" id="name" name="name" class="form-control"
                                                       value="${model.name}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right">Đường</label>
                                            <div class="col-sm-9">
                                                <input type="text" id="street" name="street" class="form-control"
                                                       value="${model.street}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right">Số tầng hầm</label>
                                            <div class="col-sm-9">
                                                <input type="number" id="numberOfBasement" name="numberOfBasement"
                                                       class="form-control" value="${model.numberOfBasement}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right"></label>
                                            <label class="col-sm-9">
                                                <c:forEach var="type" items="${buildingType}">
                                                    <input type="checkbox" class="form-check-input" name="buildingTypes"
                                                           value="${type}">
                                                    <label>${type.value}</label>
                                                </c:forEach>
                                            </label>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right"></label>
                                            <div class="col-sm-9">
                                                <button id="btnSearch" type="button" class="btn btn-sm btn-success">
                                                    Tìm kiếm
                                                    <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="table-btn-controls">
                                <div class="pull-right tableTools-container">
                                    <div class="dt-buttons btn-overlap btn-group">
                                        <a flag="info"
                                           class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                           data-toggle="tooltip"
                                           title="Thêm tòa nhà" href='<c:url value="/admin-building?type=edit" />'>
                                            <span>
                                                <i class="fa fa-plus-circle bigger-110 purple"></i>
                                            </span>
                                        </a>
                                        <button id="btnDelete" type="button" disabled
                                                class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
                                                data-toggle="tooltip" title="Xóa tòa nhà">
                                            <span>
                                                <i class="fa fa-trash-o bigger-110 pink"></i>
                                            </span>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="buildingTable">
                                        <thead>
                                        <tr>
                                            <th><input type="checkbox" class="check-box-element" id="checkAll"></th>
                                            <th>Tên Sản Phẩm</th>
                                            <th>Địa chỉ</th>
                                            <th>Tên quản lý</th>
                                            <th>Số điện thoại</th>
                                            <th>D.T sàn</th>
                                            <th>D.T trống</th>
                                            <th>Giá thuê</th>
                                            <th>Phí dịch vụ</th>
                                            <th>Phí MG</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${model.listResult}" var="item">
                                            <tr>
                                                <td><input type="checkbox" class="check-box-element"
                                                           id="checkbox_${item.id}" value="${item.id}"></td>
                                                <td>${item.name}</td>
                                                <td>${item.street}, ${item.ward}, ${item.district}</td>
                                                <td>${item.managerName}</td>
                                                <td>${item.managerPhone}</td>
                                                <td>${item.buildingArea}</td>
                                                <td>${item.rentArea}</td>
                                                <td>${item.costRent}</td>
                                                <td>${item.serviceCost}</td>
                                                <td>${item.commission}</td>
                                                <td>
                                                    <button class="btn btn-xs btn-primary btn-edit"
                                                            data-toggle="tooltip" type="button" title="Giao tòa nhà"
                                                            id="btnAssignBuilding" buildingId="${item.id}">
                                                        <i class="fa fa-tasks"></i>
                                                    </button>
                                                    <c:url value="/admin-building" var="editURL">
                                                        <c:param name="type" value="edit"/>
                                                        <c:param name="id" value="${item.id}"/>
                                                    </c:url>
                                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                       title="Cập nhập tòa nhà" href="${editURL}">
                                                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <ul class="pagination" id="pagination"></ul>
                                    <input type="hidden" value="" name="page" id="page">
                                    <input type="hidden" value="" name="maxPageItems" id="maxPageItems">
                                    <input type="hidden" value="" name="sortName" id="sortName">
                                    <input type="hidden" value="" name="sortBy" id="sortBy">
                                    <input type="hidden" value="" name="type" id="type">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div><!-- /.main-content -->

<div class="modal fade" id="assignBuildingModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Danh sách nhân viên giao tòa nhà
                </h4>
            </div>
            <div class="modal-body">
                <table class="table" id="userAssignmentTable">
                    <thead>
                    <tr>
                        <th>Chọn nhân viên</th>
                        <th>Tên nhân viên</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
                <div id="fieldHidden">

                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="btnAssignBuildingForStaff" data-dismiss="modal">Giao
                    tòa nhà
                </button>
            </div>
        </div>

    </div>
</div>

<script type="text/javascript">
    var totalPages = ${model.totalPages};
    var currentPage = ${model.page};
    var limit = 2;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (page != currentPage) {
                    $('#page').val(page);
                    $('#maxPageItems').val(limit);
                    $('#sortName').val("name");
                    $('#sortBy').val("desc");
                    $('#type').val("list");
                    $('#formSubmit').submit();
                }
            }
        });
    });

    //Khong can su dung ham find hay closest
    $('#buildingTable button#btnAssignBuilding').click(function (e) {
        e.preventDefault();
        $('#assignBuildingModal').modal();
        //load user
        var data = {};
        var buildingId = $(this).attr('buildingId');
        data["buildingId"] = buildingId;
        data["roleCode"] = 'STAFF';
        var buildingIdHidden = '<input type="hidden" name="buildingId" id="buildingId" value="' + buildingId + '">';
        $('#fieldHidden').html(buildingIdHidden);
        loadUserAssignBuilding($(this).attr('buildingId'), data);
    });

    $('#btnAssignBuildingForStaff').click(function (e) {
        e.preventDefault();
        var buildingId = $('#fieldHidden').find('#buildingId').val();
        var users = $('#userAssignmentTable').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        var data = {};
        data["buildingId"] = buildingId;
        data["ids"] = users;
        assignBuildingForStaff(data)
    });

    function assignBuildingForStaff(data) {
        $.ajax({
            url: '${assignAPI}',
            type: "PUT",
            contentType: "application/json",
            data: JSON.stringify(data),
            dataType: "json",
            success: function (result) {
                window.location.href = "<c:url value='/admin-building?type=list&page=1&maxPageItems=2&message=assign_building_success&alert=success' />"
            },
            error: function (error) {
                window.location.href = "<c:url value='/admin-building?type=list&page=1&maxPageItems=2&message=error_system&alert=danger' />"
            }
        })
    }

    function loadUserAssignBuilding(buildingId, data) {
        $.ajax({
            url: '${userAPI}',
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(data),
            dataType: "json",
            success: function (result) {
                var row = '';
                $.each(result, function (index, userModel) {
                    row += '<tr>';
                    row += '<td><input type="checkbox" id="checkbox_' + userModel.id + '" value="' + userModel.id + '" class="check-box-element" ' + userModel.checked + ' ></td>';
                    row += '<td>' + userModel.fullName + '</td>';
                    row += '</tr>';
                });
                $('#userAssignmentTable tbody').html(row);
            },
            error: function (error) {
                console.log(error);
            }
        })
    }

    $('#btnDelete').click(function (e) {
        e.preventDefault();
        var dataArray = $('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        var data = {};
        data['ids'] = dataArray;
        $.ajax({
            url: '${deleteUrl}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function () {
                window.location.href = "<c:url value='/admin-building?type=list&page=1&maxPageItems=2&message=delete_success&alert=success' />"
            },
            error: function (error) {
                window.location.href = "<c:url value='/admin-building?type=list&page=1&maxPageItems=2&message=error_system&alert=danger' />"
            }
        })
    });

    $('#btnSearch').click(function () {
        $('#maxPageItems').val(limit);
        $('#page').val(1);
        $('#type').val("list");
        $('#formSubmit').submit();
    });

</script>
</body>
</html>
