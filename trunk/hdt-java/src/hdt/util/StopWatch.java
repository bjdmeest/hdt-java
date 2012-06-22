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
package hdt.util;

public class StopWatch {
	private long ini;
	private long end;

	public StopWatch() {
		reset();
	}

	public void reset() {
		ini = end = System.nanoTime();
	}

	public void stop() {
		end = System.nanoTime();
	}

	public long getMeasure() {
		return end-ini;
	}

	public long stopAndGet() {
		stop();
		return getMeasure();
	}

	public String stopAndShow() {
		stop();
		return toString();
	}

	@Override
	public String toString() {
		return usToString(getMeasure()/1000);
	}

	private String usToString(long us) {
		long totalSecs = us/1000000;
		int hours = (int) (totalSecs / 3600);
		int mins = (int) (totalSecs / 60) % 60;
		int secs = (int) (totalSecs % 60);
		int ms = (int) (us%1000000)/1000;
		us = us % 1000;

		StringBuilder out= new StringBuilder();
		if(hours>0) {
			out.append(hours).append(" hour ");
		}
		if(mins>0) {
			out.append(mins).append(" min ");
		}
		if(secs>0) {
			out.append(secs).append(" sec ");
		}
		if(ms>0){
			out.append(ms).append(" ms ");
		}
		if(us>0) {
			out.append(us).append(" us ");
		}
		return out.toString().trim();
	}

}
