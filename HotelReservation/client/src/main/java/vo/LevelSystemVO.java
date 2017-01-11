package vo;

/**
 * 等级及相应的信用值
 * @author txin15
 *
 */
public class LevelSystemVO {
	
	/**
	 * 等级
	 */
	int levels;
	
	/**
	 * 对应等级所需要的信用值
	 */
	int credits;
	
	public LevelSystemVO() {}
	
	public LevelSystemVO(int levels, int credits) {
		this.levels = levels;
		this.credits = credits;
	}
	
	public int getLevels() {
		return levels;
	}
	
	public int getCredits() {
		return credits;
	}
	
	public void setLevels(int levels) {
		this.levels = levels;
	}
	
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
}
