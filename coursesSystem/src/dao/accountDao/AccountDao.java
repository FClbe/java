package dao.accountDao;

import com.google.gson.Gson;
import dao.IDao;
import data.account.Account;
import data.course.Course;
import data.user.Teacher;
import utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDao implements IDao<Account> {
    @Override
    public int insert(Account account) {
        if (account == null)
            return 0;

        Gson gson = new Gson();
        Object[] objects = {account.getAccountId(),account.getPassword(),account.getPersonType()};
        String sql = "insert into account values(?,?,?)";
        DBUtil dbUtil = new DBUtil();
        int result = dbUtil.doUpdate(sql, objects);
        dbUtil.close();
        return result;
    }

    @Override
    public int delete(Account account) {
        if (account == null)
            return 0;

        Object[] objects = {account.getAccountId()};
        String sql = "delete from account where account_id = ?";
        DBUtil dbUtil = new DBUtil();
        int result = dbUtil.doUpdate(sql, objects);
        dbUtil.close();
        return result;
    }

    @Override
    public int update(Account account) {
        return 0;
    }

    @Override
    public List<Account> query(Account account) {
        List<Account> list = new ArrayList<>();
        Gson gson = new Gson();
        DBUtil dbUtil = new DBUtil();

        Object[] params = {account.getAccountId()};
        String sql = "select * from account where account_id = ?";

        ResultSet rs = dbUtil.doQuery(sql, params);

        if (rs == null){
            return null;
        }
        try {
            while (rs.next()){
                Account account1 = new Account();
                account1.setAccountId(rs.getString(1));
                account1.setPassword(rs.getString(2));
                account1.setPersonType(rs.getInt(3));
                list.add(account1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        dbUtil.close();
        return list;
    }

    @Override
    public List<Account> queryAll() {
        List<Account> list = new ArrayList<>();
        Gson gson = new Gson();
        DBUtil dbUtil = new DBUtil();

        String sql = "select * from account";

        ResultSet rs = dbUtil.doQuery(sql, null);

        if (rs == null){
            return null;
        }
        try {
            while (rs.next()){
                Account account1 = new Account();
                account1.setAccountId(rs.getString(1));
                account1.setPassword(rs.getString(2));
                account1.setPersonType(rs.getInt(3));
                list.add(account1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        dbUtil.close();
        return list;
    }
}
