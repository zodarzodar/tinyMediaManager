/*
 * Copyright 2012 - 2017 Manuel Laggner
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.tinymediamanager.ui;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

import org.tinymediamanager.core.movie.entities.Movie;

/**
 * The Class BorderCellRenderer.
 * 
 * @author Manuel Laggner
 */
public class BorderCellRenderer extends DefaultTableCellRenderer {
  private static final long serialVersionUID = -6545791732880295743L;

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    setForeground(table.getForeground());
    if (isSelected) {
      setBackground(table.getSelectionBackground());
      setForeground(table.getSelectionForeground());
    }
    else {
      setBackground(table.getBackground());

    }

    // left margin
    Component comp = super.getTableCellRendererComponent(table, "", isSelected, hasFocus, row, column);
    Border defaultBorder = ((JComponent) comp).getBorder();
    defaultBorder = BorderFactory.createEmptyBorder(0, 2, 0, 0);
    this.setBorder(defaultBorder);

    if (value instanceof Movie) {
      Movie movie = (Movie) value;
      setValue(movie.getTitleSortable());
      if (movie.isNewlyAdded()) {
        setHorizontalTextPosition(SwingConstants.LEADING);
        setIcon(IconManager.NEW);
      }
      else {
        setIcon(null);
      }
    }
    else if (value != null) {
      setValue(value.toString());
    }
    else {
      setValue("");
    }

    return this;
  }
}
