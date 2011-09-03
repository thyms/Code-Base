/**
 * 
 */
package model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author Deniz KALFA
 *
 */
public abstract class BaseModel {
	// 'Transient Based' alternative codes are commented-out
	// private static final boolean INCLUDE_TRANSIENT_FIELDS = false;
	protected abstract String[] getExcludeFields();
	
	@Override
	public boolean equals(Object obj) {
		// return EqualsBuilder.reflectionEquals(this, obj, INCLUDE_TRANSIENT_FIELDS);
		return EqualsBuilder.reflectionEquals(this, obj, getExcludeFields());
	}

	@Override
	public int hashCode() {
		// return HashCodeBuilder.reflectionHashCode(this, INCLUDE_TRANSIENT_FIELDS);
		return HashCodeBuilder.reflectionHashCode(this, getExcludeFields());
	}
	
	@Override
	public String toString() {
		// return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE, INCLUDE_TRANSIENT_FIELDS);
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
