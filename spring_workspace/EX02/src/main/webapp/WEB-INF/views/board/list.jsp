<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<%@include file="../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            BoardList Page
                            <a href="/board/register" class="btn btn-primary pull-right btn-xs">글쓰기</a>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                        		<thread>
                        			<tr>
                        				<td>#번호</td>
                        				<td>제목</td>
                        				<td>작성자</td>
                        				<td>작성일</td>
                        				<td>수정일</td>
                        			</tr>
                        		</thread>
                        		<c:forEach items="${list}" var="board">
                        			<tr>
                        				<td><c:out value="${board.bno}"/></td>
                        				<td width="800">
                        					<a class='move' href='<c:out value="${board.bno}"/>'>
                        						<c:out value="${board.title}"/>
                        					</a>
                        				</td>
                        				<td><c:out value="${board.writer}"/></td>
                        				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/></td>
                        				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/> </td>
                        			</tr>
                        		</c:forEach>
                        	</table>
                 			<!-- Searching Process -->
                 			<form id="searchForm" action="/board/list" method="get">
                 				<select name='type'>
									<option value=""<c:out value="${pageMaker.cri.type==null?'selected':''}"/>>
									--
									</option>
									<option value="T">
									제목
									</option>
									<option value="C" <c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>
									내용
									</option>
									<option value="W" <c:out value="${pageMaker.cri.type eq 'W'?'selected':''}"/>>
									작성자
									</option>
									<option value="TC" <c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}"/>>
									제목or내용
									</option>
									<option value="TW" <c:out value="${pageMaker.cri.type eq 'TW'?'selected':''}"/>>
									제목or작성자
									</option>
									<option value="TCW" <c:out value="${pageMaker.cri.type eq 'TCW'?'selected':''}"/>>
									제목or내용or작성자
									</option>                 				
                 				</select>
                 				<input type='text' name='keyword' value='<c:out value="${pageMaker.cri.keyword}"/>' />
                 				<input type='hidden' name='pageNum' value='<c:out value="${pageMaker.cri.pageNum}"/>'/>
                 				<input type='hidden' name='amount' value='<c:out value="${pageMaker.cri.amount}"/>' />
                 				<button class="btn btn-default">Search</button>
                 			</form>
                        	
                        	<div class='pull-right'>
                        		<ul class="pagination">
                        			<c:if test="${pageMaker.prev}">
                        				<li class="pagination_button previous">
                        					<a href="${pageMaker.startPage -1}">Previous</a>
                        				</li>
                        			</c:if>
                        			<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                        				<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active":""}">
                        				<a href="${num}">${num}</a>
                        				</li>
                        			</c:forEach>
                        			<c:if test="${pageMaker.next}">
                        				<li class="pagenation_button next">
                        					<a href="${pageMaker.endPage +1}">Next</a>
                        				</li>
                        			</c:if>
                        		</ul>
                        	</div>
                        	<form id='actionForm' action='/board/list' method='get'>
                        		<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
                        		<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
                        	</form>
                        	<!-- table End -->
                        	
                        	<!-- modal -->
                        	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" area-labelledby="myModalLable" aria-hidden="true">
                        		<div class="modal-dialog">
                        			<div class="modal-content">
                        				<div class="modal-header">
                        					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        					<h4 class="modal-title" id="myModalLabel">Modal title</h4>
                        				</div>
                        				<div class="modal-body">처리가 완료되었습니다.</div>
                        				<div class="modal-footer">
                        					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        					<button type="button" class="btn btn-primary">Save changes</button>
                        				</div>
                        			</div>
                        			<!-- modal content -->
                        		</div>
                        		<!-- modal dialog -->
                        	</div>
                        	<!-- /modal -->
                        	<script>
                        		$(document).ready(function(){
                        			
                        			var result ='<c:out value="${result}"/>';
                    				
                        			history.replaceState({},null,null);//history 객체 state를 null로 셋팅
                        			
                        			checkModal(result);
                        			
                        			function checkModal(result){ 
                        				if(result===''){ //history state가 null이면 중지
                        					return;
                        				}
                        				if(parseInt(result)>0){
                        					$(".modal-body").html("게시글"+parseInt(result)+"번이 등록되었습니다.");
                        				}
                        				$("#myModal").modal("show");
                        			}
                        			$("#regBtn").on("click",function(){
                        				self.location="/board/register";
                        			});
                        			
                        			var actionForm =$("#actionForm");
                        			
                        			$(".paginate_button a").on("click",function(e){
                        				
                        				e.preventDefault();
                        				
                        				console.log('click');
                        				
                        				actionForm.find("input[name='pageNum']").val($(this).attr("href"));
                        				actionForm.submit();
                        			});
                        			
                        			$(".move").on("click",function(e){
                        				e.preventDefault();
                        				actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
                        				actionForm.attr("action","/board/get");
                        				actionForm.submit();
                        			});
                        			
                        			var searchForm =$("#searchForm");
                      				
                        			$("#searchForm button").on("click",function(e){
                        				if(!searchForm.find("option:selected").val()){
                        					alert("검색종류를 선택해주세요");
                        					return false;
                        				}
                        				if(!searchForm.find("input[name='keyword']").val()){
                        					alert("키워드를 입력하세요");
                        					return false;
                        				}
                        					
                        				seachForm.find("input[name='pageNum']").val("1");
                        				e.preventDefault();
                        				
                        				searchForm.submit();
                        			});
                        		})
                        		
                        	</script>
                        </div>
                    </div>
                </div>
            </div>     
<%@include file="../includes/footer.jsp" %>