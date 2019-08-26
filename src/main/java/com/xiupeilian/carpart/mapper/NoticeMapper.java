package com.xiupeilian.carpart.mapper;

import com.xiupeilian.carpart.base.BaseMapper;
import com.xiupeilian.carpart.model.Notice;

import java.util.List;

public interface NoticeMapper extends BaseMapper<Notice> {

    List<Notice> findNotice();
}