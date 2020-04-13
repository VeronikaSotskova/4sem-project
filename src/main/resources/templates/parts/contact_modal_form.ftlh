<#macro form id>
    <div class="collapse" id="collapseExample${id}">
        <div class="mt-3">
            <div class="header text-center">
                <h4 class="title w-100 font-weight-bold">Write to us</h4>
            </div>
            <form action="/sendReqAnon/to/${id}" method="post">
                <div class="mx-3">
                    <div class="md-form mb-5">
                        <i class="fas fa-user prefix grey-text"></i>
                        <input type="text" id="form34" class="form-control validate" name="name">
                        <label data-error="wrong" data-success="right" for="form34">Your name</label>
                    </div>

                    <div class="md-form mb-5">
                        <i class="fas fa-envelope prefix grey-text"></i>
                        <input type="email" id="form29" class="form-control validate" name="email">
                        <label data-error="wrong" data-success="right" for="form29">Your email</label>
                    </div>

                    <div class="md-form">
                        <i class="fas fa-pencil prefix grey-text"></i>
                        <textarea type="text" id="form8" class="md-textarea form-control" rows="4"
                                  name="message"></textarea>
                        <label data-error="wrong" data-success="right" for="form8">Your message</label>
                    </div>

                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="modal-footer d-flex justify-content-center">
                    <button type="submit" class="btn btn-unique">Send <i class="fas fa-paper-plane-o ml-1"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>

</#macro>