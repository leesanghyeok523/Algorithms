from datetime import datetime, timezone

current_utc_time = datetime.now(timezone.utc)

print(current_utc_time.year)
print(f"{current_utc_time.month:02}")  
print(f"{current_utc_time.day:02}")    
