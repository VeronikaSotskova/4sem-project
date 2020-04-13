<#include "security.ftlh">
<#import "contact_modal_form.ftlh" as f>

<#macro user_card account>
    <script src="/static/mdbootstrap2/js/addons/rating.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#rateMe3').mdbRate();
        });
    </script>
    <#if account.experience == 1>
        <#assign
        strExp = "год"
        >
    <#elseif account.experience gt 1 && account.experience lt 5>
        <#assign
        strExp = "года"
        >
    <#else>
        <#assign
        strExp = "лет"
        >
    </#if>

    <#if account.gender == 'FEMALE'>
    </#if>

    <!-- Card -->
    <div class="card testimonial-card mb-4">

        <!-- Background color -->
        <div class="card-up gradient-card-header purple-gradient">
        </div>

        <!-- Avatar -->
        <div class="avatar mx-auto white rounded-circle"><img
                    src="/img/${account.avatarFilename!'avatar.jpg'}"
                    class="rounded-circle img-responsive"
                    width="110px"
                    height="110px">
        </div>

        <div class="card-body">
            <!-- Name -->
            <h4 class="card-title mt-2"><strong>${account.name!''} ${account.surname!''}</strong></h4>
            <hr class="mb-3">
            <!-- Quotation -->
            <p><i class="fas fa-quote-left"></i>Пол: <#if account.gender == 'FEMALE'>женский<#else>мужской
                </#if>.</p>
        </div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">Age: ${account.age!''}</li>
            <li class="list-group-item">Experience: ${account.experience} ${strExp}</li>
            <#if account.about??>
                <li class="list-group-item">${account.about!''}</li>
            </#if>

        </ul>
        <#if !known>
            <!--modal-->
            <!--modal-->
            <div class="card-body text-center">
                <a class="card-link"
                   data-toggle="collapse"
                   href="#collapseExample${account.id}"
                   aria-expanded="false"
                   aria-controls="collapseExample">Написать</a>
            </div>
            <@f.form account.id />
        <#else>
            <div class="card-body">
                <a href="#" class="card-link">Написать</a>
            </div>
        </#if>
        <#--<div class="text-center">
            <a href="" class="btn btn-default btn-rounded mb-4" data-toggle="modal" data-target="#modalContactForm">Launch
                Modal Contact Form</a>
        </div>-->

    </div>


</#macro>

