/**
 * File: $HeadURL$
 * Revision: $Rev$
 * Last modified: $Date$
 * Last modified by: $Author$
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 * Contacting the authors:
 *   Mario Arias:               mario.arias@deri.org
 *   Javier D. Fernandez:       jfergar@infor.uva.es
 *   Miguel A. Martinez-Prieto: migumar2@infor.uva.es
 *   Alejandro Andres:          fuzzy.alej@gmail.com
 */

package hdt.iterator;

import hdt.enums.TripleComponentRole;
import hdt.exceptions.NotImplementedException;
import hdt.triples.TripleID;

import java.util.Iterator;

/**
 * Iterates over one of the components of a triple (E.g. all subjects, predicates or objects)
 * NOTE: It does not discard repetitions
 * @author grinbd
 * 
 */
public class RoleIteratorTripleID implements Iterator<Integer> {

	TripleComponentRole position;
	Iterator<TripleID> iterator;

	/**
	 * @param position
	 * @param array
	 */
	public RoleIteratorTripleID(Iterator<TripleID> iterator,
			TripleComponentRole position) {
		this.position = position;
		this.iterator = iterator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#next()
	 */
	@Override
	public Integer next() {
		switch (position) {
		case SUBJECT:
			return iterator.next().getSubject();
		case PREDICATE:
			return iterator.next().getPredicate();
		case OBJECT:
			return iterator.next().getObject();
		}
		// Never reached
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove() {
		throw new NotImplementedException();
	}

}
