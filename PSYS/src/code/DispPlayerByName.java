package code;

public class DispPlayerByName extends Console {
	// フィールド
	private String name;
	private PlayerList plist;
	private PlayerList selectedList;
//	private DispPlayer next;

	/**
	 * コンストラクタ DisplayPersonsByNameStatus
	 * @param String firstMess
	 * @param String promptMess
	 * @param boolean IsEndStatus
	 * @param PersonList plist
	 * @param DisplayPersonStatus next
	 */
	DispPlayerByName( String firstMess, String promptMess,
	                     boolean IsEndStatus,
	                     PlayerList plist ) {
		super( firstMess, promptMess, IsEndStatus );
		this.name = "";
		this.plist = plist;
		this.selectedList = null;
//		this.next = next;
	}

	// 最初に出力するメッセージを表示する
	/** displayFirstMess
	 * @throws Exception
	 */
	public void displayFirstMess() throws Exception {
		displayList();
		super.displayFirstMess();
	}

	// 検索する氏名を登録する
	/** setName
	 * @param String name
	 */
	public void setName( String name ) {
		this.name = name;
	}

	// 入力された選手のレコードだけを
	// 取り出す処理
	/**
	 * displayList
	 */
	public void displayList() {
		// 入力された選手のレコードだけを
		// selectedListに取り出す
		selectedList = plist.searchByName( name );
		// selectedListの件数＝0ならば当該職種をもつ
		// 選手はいないと表示
		if( selectedList.size() <= 0 )
			System.out.println( "選手が存在しません。" );
		else
			selectedList.allDisplay();
	}

	// 次の状態に遷移することを促すためのメッセージの表示
	/** getNextStatus
	 * @param String s
	 * @return ConsoleStatus
	 */
/*	public Console getNextStatus( String s ) {
		// 数値が入力された場合，その数値と同じIDをもつ
		// レコードがselectedListにあるかどうか判定し，
		// あればそれを次の状態DisplayPersonStatusに渡す      //このあたりの処理から
		try {
//			int i = Integer.parseInt( s );
			Player p = selectedList.get( s );
			if( p == null )
				return this;
			else {
				next.setPlayerRecord( p );
				return next;
			}
		} catch( NumberFormatException e ) {
			return super.getNextStatus( s );
		}
	}*/
	public Console getNextStatus(String s) {
		return super.getNextStatus(" ");
	}
}
