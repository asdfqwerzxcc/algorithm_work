function processData(newData) {
  // Pre-calculate array length for better memory allocation
  const resultSize = newData.length;
  const result = new Array(resultSize);

  // Use objects instead of Maps for better performance
  const timeGroups = {};
  const previousValues = {};
  const timeFormats = {};
  const allTags = new Set();

  // First pass: Group by time with faster for...of loop
  for (const item of newData) {
    const timeKey = new Date(item.time).getTime();
    if (!timeGroups[timeKey]) {
      timeGroups[timeKey] = {};
      timeFormats[timeKey] = item.time;
    }
    timeGroups[timeKey][item.tag] = item;
    allTags.add(item.tag);
  }

  // Convert to array once
  const sortedTimes = Object.keys(timeGroups).sort((a, b) => a - b);
  const tagsArray = Array.from(allTags);
  let resultIndex = 0;

  // Use faster for...of loops instead of forEach
  for (const timeKey of sortedTimes) {
    const currentGroup = timeGroups[timeKey];
    const originalTimeFormat = timeFormats[timeKey];

    for (const tag of tagsArray) {
      if (tag in currentGroup) {
        result[resultIndex++] = currentGroup[tag];
        previousValues[tag] = currentGroup[tag];
      } else if (previousValues[tag]) {
        result[resultIndex++] = {
          time: originalTimeFormat,
          tag,
          tagvalue: previousValues[tag].tagvalue,
        };
      }
    }
  }

  // Trim any unused array slots
  return result.slice(0, resultIndex);
}

// 테스트
const data = [
  { time: "2024-01-16T10:00:00", tag: "a", tagvalue: 1 },
  { time: "2024-01-16T10:00:00", tag: "b", tagvalue: 2 },
  { time: "2024-01-16T10:00:00", tag: "c", tagvalue: 3 },
  { time: "2024-01-16T10:01:00", tag: "b", tagvalue: 4 },
  { time: "2024-01-16T10:01:00", tag: "c", tagvalue: 5 },
  { time: "2024-01-16T10:02:00", tag: "c", tagvalue: 8 },
  { time: "2024-01-16T10:03:00", tag: "a", tagvalue: 9 },
  { time: "2024-01-16T10:03:00", tag: "c", tagvalue: 11 },
  { time: "2024-01-16T10:04:00", tag: "a", tagvalue: 12 },
];
const start = performance.now();
const result = processData(data);
const end = performance.now();

console.log(`Execution time: ${end - start} ms`);
const resultdate = [
  { time: "2024-01-16T10:00:00", tag: "a", tagvalue: 1 },
  { time: "2024-01-16T10:00:00", tag: "b", tagvalue: 2 },
  { time: "2024-01-16T10:00:00", tag: "c", tagvalue: 3 },
  { time: "2024-01-16T10:01:00", tag: "a", tagvalue: 1 },
  { time: "2024-01-16T10:01:00", tag: "b", tagvalue: 4 },
  { time: "2024-01-16T10:01:00", tag: "c", tagvalue: 5 },
  { time: "2024-01-16T10:02:00", tag: "a", tagvalue: 1 },
  { time: "2024-01-16T10:02:00", tag: "b", tagvalue: 4 },
  { time: "2024-01-16T10:02:00", tag: "c", tagvalue: 8 },
  { time: "2024-01-16T10:03:00", tag: "a", tagvalue: 9 },
  { time: "2024-01-16T10:03:00", tag: "b", tagvalue: 4 },
  { time: "2024-01-16T10:03:00", tag: "c", tagvalue: 11 },
  { time: "2024-01-16T10:04:00", tag: "a", tagvalue: 12 },
  { time: "2024-01-16T10:04:00", tag: "b", tagvalue: 4 },
  { time: "2024-01-16T10:04:00", tag: "c", tagvalue: 11 },
];
const testResult = JSON.stringify(result) === JSON.stringify(resultdate);
const moreData = [
  { time: "2024-01-16T10:05:00", tag: "a", tagvalue: 13 },
  { time: "2024-01-16T10:05:00", tag: "b", tagvalue: 14 },
  { time: "2024-01-16T10:06:00", tag: "c", tagvalue: 15 },
  { time: "2024-01-16T10:07:00", tag: "a", tagvalue: 16 },
  { time: "2024-01-16T10:07:00", tag: "b", tagvalue: 17 },
  { time: "2024-01-16T10:07:00", tag: "c", tagvalue: 18 },
];
// 대용량 데이터 샘플 생성
const largeData = [];
const tags = ["a", "b", "c", "d", "e"];
const startTime = new Date("2024-01-16T10:00:00").getTime();

for (let i = 0; i < 100000; i++) {
  const time = new Date(startTime + i * 60000).toISOString(); // 1분 간격
  const tag = tags[i % tags.length];
  const tagvalue = Math.floor(Math.random() * 100);
  largeData.push({ time, tag, tagvalue });
}

const startLarge = performance.now();
const largeResult = processData(largeData);
const endLarge = performance.now();

console.log(`Execution time for large data: ${endLarge - startLarge} ms`);
console.log(`Processed ${largeResult.length} entries`);
const start1 = performance.now();

const moreResult = processData(moreData);
const end1 = performance.now();

console.log(`Execution time: ${end1 - start1} ms`);
const moreResultDate = [
  { time: "2024-01-16T10:05:00", tag: "a", tagvalue: 13 },
  { time: "2024-01-16T10:05:00", tag: "b", tagvalue: 14 },
  { time: "2024-01-16T10:06:00", tag: "a", tagvalue: 13 },
  { time: "2024-01-16T10:06:00", tag: "b", tagvalue: 14 },
  { time: "2024-01-16T10:06:00", tag: "c", tagvalue: 15 },
  { time: "2024-01-16T10:07:00", tag: "a", tagvalue: 16 },
  { time: "2024-01-16T10:07:00", tag: "b", tagvalue: 17 },
  { time: "2024-01-16T10:07:00", tag: "c", tagvalue: 18 },
];

const testMoreResult =
  JSON.stringify(moreResult) === JSON.stringify(moreResultDate);

console.log(testMoreResult);

console.log(testResult);
