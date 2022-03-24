package actions;

import java.io.IOException;

import javax.servlet.ServletException;

import actions.views.EmployeeView;
import actions.views.ReportView;
import constants.AttributeConst;
import constants.ForwardConst;
import services.LikedService;
import services.ReportService;

public class LikedAction extends ActionBase {

    private LikedService service;

    private ReportService service_report;

    //メソッドを実行する
    @Override
    public void process() throws ServletException, IOException {

        service = new LikedService();
        service_report = new ReportService();

        //メソッドを実行
        invoke();
        service.close();
        service_report.close();
    }

    /**新規登録を行う
     * @throws ServletException
     * @throws IOException
     */

    public void create() throws ServletException, IOException {

        //CSRF対策　tokenのチェック
        if (checkToken()) {

            //日報の日付が入力されていなければ今日の日付を設定
            //LocalDate day = null;
            //day = LocalDate.now();

            //セッションからログイン中の従業員情報を取得
            EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

            //レポートを見つける
            ReportView rv = service_report.findOne(toNumber(getRequestParam(AttributeConst.REP_ID)));

            //日報情報登録
            service.create(rv, ev);

            //レポートのshowにリダイレクト
            redirect(ForwardConst.ACT_REP, ForwardConst.CMD_INDEX, rv.getId());
        }
    }

    public void remove() throws ServletException, IOException {

        //CSRF対策　tokenのチェック
        if (checkToken()) {

            //セッションからログイン中の従業員情報を取得
            EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

            //レポートを見つける
            ReportView rv = service_report.findOne(toNumber(getRequestParam(AttributeConst.REP_ID)));

            //idを条件に日報データを取得
            //LikedView lk = service.findOne(rv,ev);

            // セッションスコープ上の不要になったデータを削除
            request.getSession().removeAttribute("report_id");

            //レポートのshowにリダイレクト
            redirect(ForwardConst.ACT_REP, ForwardConst.CMD_INDEX, toNumber(getRequestParam(AttributeConst.REP_ID)));

        }

    }

}
