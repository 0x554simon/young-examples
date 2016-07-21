package softstone.paper.hivesql.visitorImpl;

import net.sf.jsqlparser.statement.SetStatement;
import net.sf.jsqlparser.statement.StatementVisitor;
import net.sf.jsqlparser.statement.Statements;
import net.sf.jsqlparser.statement.alter.Alter;
import net.sf.jsqlparser.statement.create.index.CreateIndex;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.create.view.CreateView;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.drop.Drop;
import net.sf.jsqlparser.statement.execute.Execute;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.replace.Replace;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.truncate.Truncate;
import net.sf.jsqlparser.statement.update.Update;
import org.apache.log4j.Logger;


public class StatementVisitorImpl implements StatementVisitor {
	private final static Logger log = Logger.getLogger(StatementVisitorImpl.class);
	
	public void visit(Select select) {
		PlainSelect ps=(PlainSelect)select.getSelectBody();
		SelectVisitorImpl selectVisitorImpl=new SelectVisitorImpl();
		ps.accept(selectVisitorImpl);
	}

	public void visit(Delete delete) {
		// TODO Auto-generated method stub
		log.debug("��֧��delete���");
	}

	public void visit(Update update) {
		// TODO Auto-generated method stub
		log.debug("��֧��update���");
		
	}

	public void visit(Insert insert) {
		log.debug("Insert:["+insert.toString()+"]");
		/*try {
			ResultUtil.executeSql(insert.toString());
		} catch (SQLException e) {
			ResultUtil.analyzeExceptions.add(new AnalyzeException(false, e.getMessage()));
			log.error(e.getMessage());
		}*/
	}

	public void visit(Replace replace) {
		// TODO Auto-generated method stub
		log.debug("��֧��replace���");
	}

	public void visit(Drop drop) {
		// TODO Auto-generated method stub
        log.debug("��֧��drop���");
	}

	public void visit(Truncate truncate) {
		// TODO Auto-generated method stub
		log.debug("��֧��truncate���");
	}

	public void visit(CreateIndex createIndex) {
		// TODO Auto-generated method stub
		log.debug("��֧��createIndex���");
	}

	public void visit(CreateTable createTable) {
		// TODO Auto-generated method stub
		log.debug("��֧��createTable���");
	}

	public void visit(CreateView createView) {
		// TODO Auto-generated method stub
		log.debug("��֧��createView���");
	}

	public void visit(Alter alter) {
		// TODO Auto-generated method stub
		log.debug("��֧��alter���");
	}

	public void visit(Statements stmts) {
		// TODO Auto-generated method stub
		log.debug("��֧��stmts���");
	}

	public void visit(Execute execute) {
		// TODO Auto-generated method stub
		log.debug("��֧��execute���");
	}

	public void visit(SetStatement set) {
		// TODO Auto-generated method stub
		log.debug("��֧��set���");
	}

}
