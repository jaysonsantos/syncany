/*
 * Syncany, www.syncany.org
 * Copyright (C) 2011-2014 Philipp C. Heckel <philipp.heckel@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.syncany.plugins;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The {@link org.syncany.plugins.Setup} annotation alters the initialization process.
 *
 * @see org.syncany.plugins.PluginOptions
 * @author Christian Roth <christian.roth@port17.de>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Setup {
	/**
	 * A setting's position in the initialization process (lower comes first).<br/>
	 * The order cannot be assured if two fields have the same order position.
	 */
	int order() default -1;

	/**
	 * A field description to make the meaning of a field better understandable.
	 */
	String description() default "";

	/**
	 * Suppress key inputs during initialization.
	 */
	boolean sensitive() default false;

	/**
	 * @see org.syncany.plugins.PluginOptionCallback
	 */
	Class<? extends PluginOptionCallback> callback() default PluginOptionCallback.class;
}
