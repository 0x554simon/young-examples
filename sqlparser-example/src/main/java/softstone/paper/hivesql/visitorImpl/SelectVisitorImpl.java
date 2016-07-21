package softstone.paper.hivesql.visitorImpl;

import net.sf.jsqlparser.statement.select.*;
import org.apache.log4j.Logger;
import softstone.paper.hivesql.util.PlainSelectUtil;

import java.util.List;

public class SelectVisitorImpl implements SelectVisitor {
	private final static Logger log = Logger.getLogger(SelectVisitorImpl.class);
	public void visit(PlainSelect plainSelect) {
		//ͨ��������ģʽ����selectItems
        List<SelectItem> selectItems=plainSelect.getSelectItems();
        PlainSelectUtil.acceptSelectItem(selectItems);
       
        //log.debug("distinct:"+plainSelect.getDistinct());
        
        //ͨ��������ģʽ����fromItem
      	FromItem fromItem=plainSelect.getFromItem();
      	PlainSelectUtil.acceptFromItem(fromItem);
      	
      	List<Join> joins=plainSelect.getJoins();
      	PlainSelectUtil.acceptJoin(joins);
	}

	public void visit(SetOperationList setOpList) {
		// TODO Auto-generated method stub

	}

	public void visit(WithItem withItem) {
		// TODO Auto-generated method stub

	}

}
