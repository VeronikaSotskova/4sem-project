<#macro edit_patient>
    <style>
        .card.card-cascade .view.gradient-card-header {
            padding: 1.1rem 1rem;
        }

        .card.card-cascade .view {
            box-shadow: 0 5px 12px 0 rgba(0, 0, 0, 0.2), 0 2px 8px 0 rgba(0, 0, 0, 0.19);
        }
    </style>



    <!-- Section: Edit Account -->
    <section class="section">
        <!-- First row -->
        <div class="row">
            <!-- First column -->
            <div class="col-lg-4 mb-4">

                <!-- Card -->
                <div class="card card-cascade narrower">

                    <!-- Card image -->
                    <div class="view view-cascade gradient-card-header mdb-color lighten-3">
                        <h5 class="mb-0 font-weight-bold">Edit Photo</h5>
                    </div>
                    <!-- Card image -->

                    <!-- Card content -->
                    <div class="card-body card-body-cascade text-center">
                        <img src="/img/${acc.avatarFilename!'avatar.jpg'}" alt="User Photo"
                             class="z-depth-1 mb-3 mx-auto" style="max-width: 190px"/>

                        <p class="text-muted"><small>Profile photo will be changed automatically</small></p>
                        <div class="row flex-center">
                            <form action="/profile/sendImage" method="post" enctype="multipart/form-data">
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                <div class="custom-file">
                                    <input type="file" class="custom-file-input" id="customFile" name="file">
                                    <label class="custom-file-label" for="customFile">Choose file</label>
                                </div>
                                <button type="submit" class="btn btn-info btn-rounded btn-sm">Upload New Photo</button>
                            </form>
                        </div>
                    </div>
                    <!-- Card content -->

                </div>
                <!-- Card -->

            </div>
            <!-- First column -->

            <!-- Second column -->
            <div class="col-lg-8 mb-4">

                <!-- Card -->
                <div class="card card-cascade narrower">

                    <!-- Card image -->
                    <div class="view view-cascade gradient-card-header mdb-color lighten-3">
                        <h5 class="mb-0 font-weight-bold">Edit Account</h5>
                    </div>
                    <!-- Card image -->

                    <!-- Card content -->
                    <div class="card-body card-body-cascade text-center">

                        <!-- Edit Form -->
                        <form role="form" action="/profile/patient" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <!-- First row -->

                            <div class="row">

                                <!-- First column -->
                                <div class="col-md-6">
                                    <div class="md-form mb-0">
                                        <input type="text" id="form1"
                                               class="form-control validate ${(nameError??)?string('is-invalid','')}"
                                               value="${acc.name!''}"
                                               name="name">
                                        <#if nameError??>
                                            <div class="invalid-feedback">
                                                ${nameError}
                                            </div>
                                        </#if>
                                        <label for="form1" data-error="wrong" data-success="right">Name</label>

                                    </div>
                                </div>
                                <!-- Second column -->
                                <div class="col-md-6">
                                    <div class="md-form mb-0">
                                        <input type="text" id="form2"
                                               class="form-control validate ${(surnameError??)?string('is-invalid','')}"
                                               name="surname"
                                               value="${acc.surname!''}">
                                        <#if surnameError??>
                                            <div class="invalid-feedback">
                                                ${surnameError}
                                            </div>
                                        </#if>
                                        <label for="form2" data-error="wrong" data-success="right">Surname</label>
                                    </div>
                                </div>
                            </div>
                            <!-- First row -->

                            <!-- First row -->
                            <div class="row">
                                <!-- First column -->
                                <div class="col-md-6">
                                    <div class="md-form mb-0">
                                        <input type="text" id="form81"
                                               class="form-control validate ${(patronymicError??)?string('is-invalid','')}"
                                               name="patronymic" value="${acc.patronymic!''}">
                                        <#if patronymicError??>
                                            <div class="invalid-feedback">
                                                ${patronymicError}
                                            </div>
                                        </#if>
                                        <label for="form81" data-error="wrong" data-success="right">Patronymic</label>
                                    </div>
                                </div>

                                <!-- Second column -->
                                <div class="col-md-6">
                                    <div class="md-form mb-0">
                                        <input type="number" id="form82"
                                               class="form-control validate ${(ageError??)?string('is-invalid','')}"
                                               value="${acc.age!''}"
                                               name="age"
                                               min="0"
                                               max="120"
                                               step="1">
                                        <#if ageError??>
                                            <div class="invalid-feedback">
                                                ${ageError}
                                            </div>
                                        </#if>
                                        <label for="form82" data-error="wrong" data-success="right">Age</label>
                                    </div>
                                </div>
                            </div>
                            <!-- First row -->

                            <!-- Second row -->
                            <div class="row">


                                <!-- First column -->
                                <div class="col-md-6">
                                    <div class="md-form mb-0">
                                        <input type="email" id="form76" class="form-control validate disabled" readonly
                                               name="email" value="${acc.email!''}">
                                        <label for="form76">Email address</label>
                                    </div>
                                </div>
                                <!-- Second column -->
                            </div>
                            <!-- Second row -->

                            <!-- Third row -->
                            <div class="row">

                                <!-- First column -->
                                <div class="col-md-12">
                                    <div class="md-form mb-0">
                                        <textarea type="text" id="form78" class="md-textarea form-control" rows="3"
                                                  name="problem" placeholder="">${acc.problem!''}</textarea>
                                        <label for="form78">About me</label>
                                    </div>
                                </div>
                            </div>

                            <!-- Third row -->

                            <!-- Fourth row -->
                            <div class="row">
                                <div class="col-md-12 text-center my-4">
                                    <button type="submit" class="btn btn-info btn-rounded">Update Account</button>
                                </div>
                            </div>
                            <!-- Fourth row -->


                        </form>
                        <!-- Edit Form -->

                    </div>
                    <!-- Card content -->

                </div>
                <!-- Card -->

            </div>
            <!-- Second column -->

        </div>
        <!-- First row -->

    </section>
    <!-- Section: Edit Account -->


</#macro>