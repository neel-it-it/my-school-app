package com.example.schoolmanagement.api;

import com.example.schoolmanagement.response.parent_login_response.ParentloginResponse;
import com.example.schoolmanagement.response.staff_profile_display.StaffProfileDisplayResponse;
import com.example.schoolmanagement.response.staff_profile_updateResponse;
import com.example.schoolmanagement.response.stu_homework.StuHomeworkResponse;
import com.example.schoolmanagement.response.stu_profile_display.StuProfileDisplayResponse;
import com.example.schoolmanagement.response.stu_profile_update.StuProfileUpdateResponse;
import com.example.schoolmanagement.response.student_login_response.LoginResponse;
import com.example.schoolmanagement.response.teacher_login_response.TeacherloginResponse;
import com.example.schoolmanagement.response.teacher_profile_display.TeacherProfileDisplayResponse;
import com.example.schoolmanagement.response.teacher_profile_update.TeacherProfileUpdateResponse;
import com.example.schoolmanagement.response.teacheraddhomework.TeacherAddHomeworkResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("stu_login.php")
    @FormUrlEncoded
    Call<LoginResponse> login(@Field("student_id") String student_id, @Field("stu_password") String stu_password);

    @POST("staff_login.php")
    @FormUrlEncoded
    Call<TeacherloginResponse> teacherlogin(@Field("staff_id") String staff_id, @Field("staff_password") String staff_password);

    @POST("parent_login.php")
    @FormUrlEncoded
    Call<ParentloginResponse> parentlogin(@Field("parent_id") String parent_id, @Field("parent_password") String parent_password);

   @POST("staff_profile_update(1).php")
    Call<staff_profile_updateResponse> staffprofileupdate(@Body RequestBody staffprofileupdatebody);

   @POST("teacher_profile_dis.php")
   @FormUrlEncoded
    Call<StaffProfileDisplayResponse> staffprofiledisplay(@Field("staff_id") String staff_id);

   @POST("stu_homework.php")
   @FormUrlEncoded
    Call<StuHomeworkResponse> stuhomework(@Field("student_id") String student_id);

    @POST("stu_profile_display.php")
    @FormUrlEncoded
    Call<StuProfileDisplayResponse> stuprofiledisplay(@Field("student_id") String student_id);

    @POST("stu_profile_update.php")
    Call<StuProfileUpdateResponse> stuprofileupdate(@Body RequestBody stuprofileupdatebody);

    @POST("staff_profile_display.php")
    @FormUrlEncoded
    Call<TeacherProfileDisplayResponse> teacherprofiledisplay(@Field("staff_id") String staff_id);

    @POST("staff_profile_update.php")
    Call<TeacherProfileUpdateResponse> teacherprofileupdate(@Body RequestBody staffprofileupdatebody);

    @POST("homework_history.php")
    @FormUrlEncoded
    Call<TeacherAddHomeworkResponse> teacherAddHomework(@Field("staff_id") String staff_id);
}
