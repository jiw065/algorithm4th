package algorithems4th.sorting;


public class DateSortAndSearch {

	public static class Date {
		int year, month, day,index;
		public Date(int y, int m, int d,int i) {
			year = y;
			month = m;
			day = d;
			index = i;
		}
		
		public int compareDays(Date d1) {			
			return year > d1.year ? 1 
					: year < d1.year ? -1 
					: month > d1.month ? 1
					: month < d1.month ? -1
					: day > d1.day ? 1 
					: day < d1.day ? -1 : 0;  //when equals will go to next layer
		}	
	}
	
	public static void main(String[] args) {
		  Date[] dates = {new Date(2014, 1, 12, 0),
				  		  new Date(2013, 12, 12, 1),
				  		  new Date(2017, 4, 22, 2),
						  new Date(2014, 1, 28, 3),
			              new Date(2014, 1, 12, 4),
			              new Date(2013, 3, 22, 5),		
				  
		  };

		//dateInsertingSort(dates);		
		//printDates(dates);
		  dateBinarySearch(dates,new Date(2014, 1, 28, 3));

		 
	}
	private static void dateBinarySearch(Date[] d,Date s) {
		dateInsertingSort(d);
		int start = 0;
		int end = d.length-1;
		int m = (start + end)/2;
		
		while(start <= end) {
			if (s.compareDays(d[m]) == 0) {
				System.out.println(d[m].index);
				return; 
			}else if (s.compareDays(d[m]) == -1) {
				end = m - 1;
			}else if (s.compareDays(d[m]) == 1) {
				start = m + 1;
			}
			m = (start + end)/2; 
			
		}
		System.out.println(d[m].index);
	
	}
	private static void dateInsertingSort(Date[] dates) {
		int preIndex = 0;
		Date current = null;
		for (int i=0; i<dates.length-1; i++) {
			preIndex = i+1;
			current = dates[preIndex];
			for (int j=i; j>=0; j--) {
				if (current.compareDays(dates[j]) == -1) {
					dates[j+1] = dates[j];
					preIndex--;
				}
			}
			dates[preIndex] = current;
		}
		
	}


	
	private static void printDates(Date[] da) {
		for (int i=0; i<da.length; i++) {
			System.out.println(da[i].year+" "+da[i].month+" "+da[i].day+" ");
		}
		System.out.println();
	}
 

}
