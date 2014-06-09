/**
 * This file is part of mycollab-ui.
 *
 * mycollab-ui is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-ui is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-ui.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.esofthead.mycollab.vaadin.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.esofthead.mycollab.common.localization.GenericI18Enum;
import com.esofthead.mycollab.common.localization.WindowI18nEnum;
import com.esofthead.mycollab.vaadin.AppContext;
import com.vaadin.server.Page;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

/**
 * 
 * @author MyCollab Ltd.
 * @since 1.0
 * 
 */
public class NotificationUtil {

	private static Logger log = LoggerFactory.getLogger(NotificationUtil.class);

	public static void showNotification(String caption) {
		showNotification(caption, null, Type.HUMANIZED_MESSAGE);
	}

	public static void showWarningNotification(String description) {
		showNotification(
				AppContext.getMessage(WindowI18nEnum.WARNING_WINDOW_TITLE),
				description, Type.WARNING_MESSAGE);
	}

	public static void showErrorNotification(String description) {
		showNotification(
				AppContext.getMessage(WindowI18nEnum.ERROR_WINDOW_TITLE),
				description, Type.ERROR_MESSAGE);
	}

	public static void showNotification(String caption, String description,
			Type type) {
		Notification warnNotif = new Notification(caption, description, type);
		warnNotif.setHtmlContentAllowed(true);
		warnNotif.setDelayMsec(3000);

		if (Page.getCurrent() != null) {
			warnNotif.show(Page.getCurrent());
		} else {
			log.error("Current page is null");
		}

	}

	public static void showGotoLastRecordNotification() {
		showNotification(
				AppContext.getMessage(WindowI18nEnum.INFORMATION_WINDOW_TITLE),
				AppContext
						.getMessage(GenericI18Enum.INFORMATION_GOTO_LAST_RECORD),
				Type.HUMANIZED_MESSAGE);
	}

	public static void showGotoFirstRecordNotification() {
		showNotification(
				AppContext.getMessage(WindowI18nEnum.INFORMATION_WINDOW_TITLE),
				AppContext
						.getMessage(GenericI18Enum.INFORMATION_GOTO_FIRST_RECORD),
				Type.HUMANIZED_MESSAGE);
	}

	public static void showRecordNotExistNotification() {
		showNotification(
				AppContext.getMessage(WindowI18nEnum.INFORMATION_WINDOW_TITLE),
				AppContext
						.getMessage(GenericI18Enum.INFORMATION_RECORD_IS_NOT_EXISTED_MESSAGE),
				Type.HUMANIZED_MESSAGE);
	}

	public static void showMessagePermissionAlert() {
		showNotification(
				AppContext.getMessage(WindowI18nEnum.WARNING_WINDOW_TITLE),
				AppContext.getMessage(WindowI18nEnum.NO_PERMISSION_DO_TASK),
				Type.WARNING_MESSAGE);
	}
}
