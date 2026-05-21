package com.ohgiraffers.jsonjdbc.api;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.jsonjdbc.common.JDBCTemplate.close;
import static com.ohgiraffers.jsonjdbc.common.JDBCTemplate.getConnection;

public class MemoService {

    private final MemoDao memoDao = new MemoDao();

    public List<MemoDto> findAllMemos() {

        Connection con = getConnection();

        try {
            return memoDao.selectAllMemos(con);
        } finally {
            close(con);
        }
    }

    public MemoDto registMemo(String content) {
        Connection con = getConnection();

        try {
            return memoDao.insertMemo(con, content);
        } finally {
            close(con);
        }
    }
}
