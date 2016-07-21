package softstone.paper.hivesql.visitorImpl;

import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.statement.select.AllColumns;
import net.sf.jsqlparser.statement.select.AllTableColumns;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.statement.select.SelectItemVisitor;
import org.apache.log4j.Logger;
import softstone.paper.hivesql.AnalyzeException;
import softstone.paper.hivesql.util.ResultUtil;

public class SelectItemVisitorImpl implements SelectItemVisitor {
	private final static Logger log = Logger.getLogger(SelectItemVisitorImpl.class);
	public void visit(AllColumns allColumns) {
		//ֻ��*��ȡ�����Ȼ��õ���
		ResultUtil.columns.add(allColumns.toString());
	}

	public void visit(AllTableColumns allTableColumns) {
		//���б�����ĵ�*
		ResultUtil.columns.add(allTableColumns.toString());
	}

	public void visit(SelectExpressionItem selectExpressionItem) {
		
		//���as name
		Alias alias=selectExpressionItem.getAlias();
		
		if(alias!=null){
			log.debug("alias.getName():"+alias.getName());
			ResultUtil.columns.add(alias.getName());
		}else{
			String exp=selectExpressionItem.getExpression().toString();
			log.debug("selectExpression:"+exp);
			if(exp.contains("(")||exp.contains(")")){
				ResultUtil.analyzeExceptions.add(new AnalyzeException(false, "��ҪΪ����"+exp+"ָ������"));
			}
			else
				ResultUtil.columns.add(exp);
		}
	}

}
