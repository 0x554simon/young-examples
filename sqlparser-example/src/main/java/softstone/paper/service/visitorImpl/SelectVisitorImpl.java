package softstone.paper.service.visitorImpl;

import net.sf.jsqlparser.statement.select.*;
import softstone.paper.service.util.PlainSelectUtil;


public class SelectVisitorImpl implements SelectVisitor {
	public void visit(PlainSelect plainSelect) {
        //ͨ��������ģʽ����fromItem
      	FromItem fromItem=plainSelect.getFromItem();
      	PlainSelectUtil.acceptFromItem(fromItem);
	}

	public void visit(SetOperationList setOpList) {

	}

	public void visit(WithItem withItem) {

	}

}
