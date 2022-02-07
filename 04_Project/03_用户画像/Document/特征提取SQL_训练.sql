
1  用户访问各个商品的一级分类的日志 
 select  user_id , category1_id ,during_time 
     from dwd_page_log   pl  join  dim_sku_info  si  on  page_item = si.id 
    where pl.page_id ='good_detail' and page_item_type='sku_id'    and  pl.dt='2021-05-16'
    and si.dt='2021-05-16'
     limit 10;
2  每个用户 每个一级分类 的访问次数 和总访问时长 

  with  user_c1
  as(
     select  user_id , category1_id ,during_time 
     from dwd_page_log   pl  join  dim_sku_info  si  on  page_item = si.id 
    where pl.page_id ='good_detail' and page_item_type='sku_id'    and  pl.dt='2021-05-16'
    and si.dt='2021-05-16'
  )
  select  user_id , category1_id ,count(*) ct , sum(during_time) dur_time
  from user_c1
  group by   user_id , category1_id
  order by user_id,category1_id;
	 
3 组内排名  --  为 每个用户的     各个一级分类访问次数进行排名   
   开窗
   with  user_c1
  as(
     select  user_id , category1_id ,during_time 
     from dwd_page_log   pl  join  dim_sku_info  si  on  page_item = si.id 
    where pl.page_id ='good_detail' and page_item_type='sku_id'    and  pl.dt='2021-05-16'
    and si.dt='2021-05-16'
  )
  select  user_id ,category1_id  ,ct, dur_time ,
   row_number()over( partition by  user_id  order by ct desc   )  rk
   from 
  ( 
    select  user_id , category1_id ,count(*) ct , sum(during_time) dur_time
    from user_c1
    group by   user_id , category1_id
    order by user_id,category1_id 
   ) user_c1_ct
   order by user_id,category1_id;
   
   
4  行转列  把 排名值   ，变为列    --> sum(if( ))   //  思考 ：  如果c1 是非数字字符串 如何解决？

  with  user_c1
  as(
     select  user_id , category1_id ,during_time 
     from dwd_page_log   pl  join  dim_sku_info  si  on  page_item = si.id 
    where pl.page_id ='good_detail' and page_item_type='sku_id'    and  pl.dt='2021-05-16'
    and si.dt='2021-05-16'
  )  
  select  user_id , cast( category1_id  as  bigint) c1 ,ct, dur_time ,
   row_number()over( partition by  user_id  order by ct desc   )  rk
   from 
  ( 
    select  user_id , category1_id ,count(*) ct , sum(during_time) dur_time
    from user_c1
    group by   user_id , category1_id
   ) user_c1_ct
  ) user_rk
  group by user_id 
    
  order  by user_id;
   
   order by user_id,category1_id;




5 显著男性常用商品 访问时长 和  显著男性常用商品访问时长
with  user_c1
  as(
     select  user_id , category1_id ,during_time 
     from dwd_page_log   pl  join  dim_sku_info  si  on  page_item = si.id 
    where pl.page_id ='good_detail' and page_item_type='sku_id'    and  pl.dt='2021-05-16'
    and si.dt='2021-05-16'
  ) 
  select    user_id, 
     sum(if(rk =1 ,c1,0)) c1_rk1, 
    sum(if(rk =2 ,c1,0)) c1_rk2,
     sum(if(rk =3 ,c1,0)) c1_rk3,
    sum(if( c1 in (3,4,6) ,dur_time,0) ) male_dur,
    sum(if( c1 in (8,11,15) ,dur_time,0) ) female_dur   
   from 
  (
  select  user_id , cast( category1_id  as  bigint) c1 ,ct, dur_time ,
   row_number()over( partition by  user_id  order by ct desc   )  rk
   from 
  ( 
    select  user_id , category1_id ,count(*) ct , sum(during_time) dur_time
    from user_c1
    group by   user_id , category1_id
   ) user_c1_ct
  ) user_rk
  group by user_id 
      
	  
	  
	  
   6  关联 用户填写的性别
  
    with  user_c1
  as(
     select  user_id , category1_id ,during_time 
     from dwd_page_log   pl  join  dim_sku_info  si  on  page_item = si.id 
    where pl.page_id ='good_detail' and page_item_type='sku_id'    and  pl.dt='2021-04-23'
    and si.dt='2021-04-23'
  ),
  user_label
  as 
  (   select id,gender   from dim_user_info ui where ui.dt='9999-99-99' and  gender<>''
  ) 
  select 
   user_id,
   c1_rk1,
   c1_rk2,
   c1_rk3,
   male_dur,
   female_dur,
   user_label.gender 
  from  
  ( 
  select    user_id, 
     sum(if(rk =1 ,c1,0)) c1_rk1, 
    sum(if(rk =2 ,c1,0)) c1_rk2,
     sum(if(rk =3 ,c1,0)) c1_rk3,
    sum(if( c1 in (3,4,6) ,dur_time,0) ) male_dur,
    sum(if( c1 in (8,11,15) ,dur_time,0) ) female_dur   
   from 
  (
  select  user_id , cast( category1_id  as  bigint) c1 ,ct, dur_time ,
   row_number()over( partition by  user_id  order by ct desc   )  rk
   from 
  ( 
    select  user_id , category1_id ,count(*) ct , sum(during_time) dur_time
    from user_c1
    group by   user_id , category1_id
   ) user_c1_ct
  ) user_rk
  group by user_id 
  ) user_feature    join   user_label  on user_feature.user_id = user_label.id 
  
  7.每日预测
  
    with  user_c1
  as(
     select  user_id , category1_id ,during_time 
     from dwd_page_log   pl  join  dim_sku_info  si  on  page_item = si.id 
    where pl.page_id ='good_detail' and page_item_type='sku_id'    and  pl.dt='2021-04-23'
    and si.dt='2021-04-23'
  ),
  user_label
  as 
  (   select id,gender   from dim_user_info ui where ui.dt='9999-99-99' and  gender is null
  ) 
  select 
   user_id,
   c1_rk1,
   c1_rk2,
   c1_rk3,
   male_dur,
   female_dur
  from  
  ( 
  select    user_id, 
     sum(if(rk =1 ,c1,0)) c1_rk1, 
    sum(if(rk =2 ,c1,0)) c1_rk2,
     sum(if(rk =3 ,c1,0)) c1_rk3,
    sum(if( c1 in (3,4,6) ,dur_time,0) ) male_dur,
    sum(if( c1 in (8,11,15) ,dur_time,0) ) female_dur   
   from 
  (
  select  user_id , cast( category1_id  as  bigint) c1 ,ct, dur_time ,
   row_number()over( partition by  user_id  order by ct desc   )  rk
   from 
  ( 
    select  user_id , category1_id ,count(*) ct , sum(during_time) dur_time
    from user_c1
    group by   user_id , category1_id
   ) user_c1_ct
  ) user_rk
  group by user_id 
  ) user_feature    join   user_label  on user_feature.user_id = user_label.id 